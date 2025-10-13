package com.fliad.viid.modular.cascadeplatform.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.fliad.viid.modular.ape.entity.ViidApe;
import com.fliad.viid.modular.ape.service.ViidApeService;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;
import com.fliad.viid.modular.cascadeplatform.enums.RegisterStatusEnum;
import com.fliad.viid.modular.cascadeplatform.enums.OnlineStatusEnum;
import com.fliad.viid.modular.cascadeplatform.enums.PlatformTypeEnum;
import com.fliad.viid.modular.cascadeplatform.service.ViidPlatformStatusService;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.util.RunUtil;
import org.noear.solon.data.cache.CacheService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 视图库平台状态服务实现类
 * 专门用于管理平台的注册状态和在线状态
 *
 * @author your-name
 * @since 2025-08-21
 */
@Slf4j
@Component
public class ViidPlatformStatusServiceImpl implements ViidPlatformStatusService, LifecycleBean {

    @Inject
    ViidCascadePlatformService cascadePlatformService;

    @Inject
    ViidApeService viidApeService;

    @Inject
    CacheService cacheService;

    // 根据设备ID获取采集设备信息
    private ViidApe getApeByDeviceId(String deviceId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("ApeID", deviceId);
        return viidApeService.getOne(queryWrapper);
    }

    // 存储已注册的下级平台设备ID
    private final List<String> registeredDeviceIds = new ArrayList<>();
    // 记录在线的设备ID
    private final List<String> onlineDeviceIds = new ArrayList<>();

    // 存储设备最后活跃时间
    private final Map<String, Date> deviceLastActiveTime = new ConcurrentHashMap<>();

    /**
     * 系统启动时初始化
     */
    @Override
    public void start() throws Throwable {
        // 初始化启动，更新所有平台状态为离线状态
        updateAllPlatformsOffline();
        // 记录所有已经注册的设备（下级平台）
        registeredDeviceIds.addAll(cascadePlatformService.list(cascadePlatformService.query().eq(ViidCascadePlatform::getType, PlatformTypeEnum.SUBORDINATE.getCode())
                        .eq(ViidCascadePlatform::getIsRegister, RegisterStatusEnum.REGISTERED.getCode()))
                .stream().map(ViidCascadePlatform::getSystemId).collect(Collectors.toList()));

        // 添加所有采集设备到已注册列表（默认注册）
        List<ViidApe> allApes = viidApeService.list();
        if (CollectionUtil.isNotEmpty(allApes)) {
            for (ViidApe ape : allApes) {
                if (!registeredDeviceIds.contains(ape.getApeID())) {
                    registeredDeviceIds.add(ape.getApeID());
                }
            }
            log.info("系统启动时将所有采集设备添加到已注册列表，共添加{}个设备", allApes.size());
        }

        // 定时检查设备是否超时（下级平台是否在线）
        RunUtil.delayAndRepeat(this::checkDeviceTimeout, 30 * 1000);
    }

    /**
     * 检查设备是否超时，如果超时则更新为离线状态
     */
    private void checkDeviceTimeout() {
        try {
            Date now = new Date();
            for (Map.Entry<String, Date> entry : deviceLastActiveTime.entrySet()) {
                String deviceId = entry.getKey();
                Date lastActiveTime = entry.getValue();

                // 先尝试从缓存获取采集设备信息
                ViidApe viidApe = cacheService.getOrStore("ape_" + deviceId, ViidApe.class, 60 * 10, () -> {
                    return getApeByDeviceId(deviceId);
                });

                // 如果没有找到采集设备信息，则尝试获取视图库平台信息
                ViidCascadePlatform cascadePlatform = null;
                if (viidApe == null) {
                    cascadePlatform = cacheService.getOrStore(deviceId + "_" + PlatformTypeEnum.SUBORDINATE.getCode(), ViidCascadePlatform.class, 60 * 10, () -> {
                        QueryWrapper queryWrapper = new QueryWrapper();
                        queryWrapper.eq(ViidCascadePlatform::getSystemId, deviceId);
                        queryWrapper.eq(ViidCascadePlatform::getType, PlatformTypeEnum.SUBORDINATE.getCode());
                        return cascadePlatformService.getOne(queryWrapper);
                    });
                }

                long heartbeatInterval = 0;
                int keepaliveTimeoutCount = 0;

                if (viidApe != null) {
                    // 对于采集设备，使用默认值
                    heartbeatInterval = 90L;
                    keepaliveTimeoutCount = 3;
                } else if (cascadePlatform != null) {
                    heartbeatInterval = cascadePlatform.getHeartbeatInterval();
                    keepaliveTimeoutCount = cascadePlatform.getKeepaliveTimeoutCount();
                }

                // 如果距离上次活跃时间超过 (心跳间隔 * 保活超时次数) 秒，则认为设备已离线
                if (((now.getTime() - lastActiveTime.getTime()) / 1000) > heartbeatInterval * keepaliveTimeoutCount) {
                    // 更新平台为离线状态
                    updateDeviceStatus(deviceId, RegisterStatusEnum.REGISTERED.getCode(), OnlineStatusEnum.OFFLINE.getCode());
                    log.info("设备{}已离线，最后活跃时间: {}", deviceId, lastActiveTime);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 更新设备状态（支持视图库平台和采集设备）
     *
     * @param deviceId   设备ID
     * @param isRegister 注册状态
     * @param isOnline   在线状态
     */
    private void updateDeviceStatus(String deviceId, String isRegister, String isOnline) {
        try {
            // 先尝试获取采集设备信息
            ViidApe viidApe = cacheService.getOrStore("ape_" + deviceId, ViidApe.class, 60 * 10, () -> {
                return getApeByDeviceId(deviceId);
            });

            // 如果没有找到采集设备信息，则尝试获取视图库平台信息
            ViidCascadePlatform cascadePlatform = null;
            if (viidApe == null) {
                cascadePlatform = cacheService.getOrStore(deviceId + "_" + PlatformTypeEnum.SUBORDINATE.getCode(), ViidCascadePlatform.class, 60 * 10, () -> {
                    QueryWrapper queryWrapper = new QueryWrapper();
                    queryWrapper.eq(ViidCascadePlatform::getSystemId, deviceId);
                    queryWrapper.eq(ViidCascadePlatform::getType, PlatformTypeEnum.SUBORDINATE.getCode());
                    return cascadePlatformService.getOne(queryWrapper);
                });
            }

            // 更新采集设备状态
            if (viidApe != null) {
                // 采集设备的在线状态更新逻辑
                viidApe.setIsOnline(OnlineStatusEnum.ONLINE.getCode().equals(isOnline) ? 1 : 0);

                // 内存状态和即将更新的状态不一致时，更新数据库
                if ((registeredDeviceIds.contains(deviceId) && RegisterStatusEnum.UNREGISTERED.getCode().equals(isOnline)) ||
                        (!registeredDeviceIds.contains(deviceId) && RegisterStatusEnum.REGISTERED.getCode().equals(isOnline)) ||
                        (onlineDeviceIds.contains(deviceId) && OnlineStatusEnum.OFFLINE.getCode().equals(isOnline)) ||
                        (!onlineDeviceIds.contains(deviceId) && OnlineStatusEnum.ONLINE.getCode().equals(isOnline))
                ) {
                    // 更新数据库
                    QueryWrapper updateWrapper = new QueryWrapper();
                    updateWrapper.eq("ApeID", deviceId);
                    viidApeService.update(viidApe, updateWrapper);
                }

                // 根据注册状态更新设备列表
                if (RegisterStatusEnum.REGISTERED.getCode().equals(isRegister)) {
                    if (!registeredDeviceIds.contains(deviceId)) {
                        registeredDeviceIds.add(deviceId);
                    }
                    if (OnlineStatusEnum.ONLINE.getCode().equals(isOnline)) {
                        // 更新设备最后活跃时间
                        deviceLastActiveTime.put(deviceId, new Date());
                        onlineDeviceIds.add(deviceId);
                    } else {
                        // 离线
                        onlineDeviceIds.remove(deviceId);
                    }
                } else if (RegisterStatusEnum.UNREGISTERED.getCode().equals(isRegister)) {
                    registeredDeviceIds.remove(deviceId);
                    deviceLastActiveTime.remove(deviceId);
                    onlineDeviceIds.remove(deviceId);
                }

                OnlineStatusEnum onlineStatus = OnlineStatusEnum.getByCode(isOnline);
                // log.info("更新设备{}在线状态为: {}", deviceId, onlineStatus != null ? onlineStatus.getName() : "未知状态");
            }
            // 更新视图库平台状态
            else if (cascadePlatform != null) {
                cascadePlatform.setIsRegister(isRegister);
                cascadePlatform.setIsOnline(isOnline);
                cascadePlatform.setLastOnlineTime(new Date());

                // 内存状态和即将更新的状态不一致时，更新数据库
                if ((registeredDeviceIds.contains(deviceId) && RegisterStatusEnum.UNREGISTERED.getCode().equals(isOnline)) ||
                        (!registeredDeviceIds.contains(deviceId) && RegisterStatusEnum.REGISTERED.getCode().equals(isOnline)) ||
                        (onlineDeviceIds.contains(deviceId) && OnlineStatusEnum.OFFLINE.getCode().equals(isOnline)) ||
                        (!onlineDeviceIds.contains(deviceId) && OnlineStatusEnum.ONLINE.getCode().equals(isOnline))
                ) {
                    cascadePlatformService.updateById(cascadePlatform);
                }

                // 根据注册状态更新设备列表
                if (RegisterStatusEnum.REGISTERED.getCode().equals(isRegister)) {
                    if (!registeredDeviceIds.contains(deviceId)) {
                        registeredDeviceIds.add(deviceId);
                    }
                    if (OnlineStatusEnum.ONLINE.getCode().equals(isOnline)) {
                        // 更新设备最后活跃时间
                        deviceLastActiveTime.put(deviceId, new Date());
                        onlineDeviceIds.add(deviceId);
                    } else {
                        // 离线
                        onlineDeviceIds.remove(deviceId);
                    }
                } else if (RegisterStatusEnum.UNREGISTERED.getCode().equals(isRegister)) {
                    registeredDeviceIds.remove(deviceId);
                    deviceLastActiveTime.remove(deviceId);
                    onlineDeviceIds.remove(deviceId);
                }

                OnlineStatusEnum onlineStatus = OnlineStatusEnum.getByCode(isOnline);
                // log.info("更新平台{}在线状态为: {}", deviceId, onlineStatus != null ? onlineStatus.getName() : "未知状态");
            }
        } catch (Exception e) {
            log.error("更新设备在线状态异常，设备ID: {}", deviceId, e);
        }
    }

    /**
     * 更新所有平台状态为离线状态
     */
    private void updateAllPlatformsOffline() {
        try {
            // 查询所有平台
            List<ViidCascadePlatform> platformList = cascadePlatformService.list();
            if (CollectionUtil.isNotEmpty(platformList)) {
                for (ViidCascadePlatform platform : platformList) {
                    platform.setIsOnline(OnlineStatusEnum.OFFLINE.getCode());
                    // 确保设置ID以便正确更新
                    platform.setId(platform.getId());
                }
                // 使用updateById方法逐个更新平台状态
                cascadePlatformService.updateBatch(platformList);
                log.info("系统启动时更新所有平台状态为离线，共更新{}个平台", platformList.size());
            } else {
                log.info("系统启动时未发现任何平台配置");
            }

            // 查询所有采集设备并更新为离线状态
            List<ViidApe> apeList = viidApeService.list();
            if (CollectionUtil.isNotEmpty(apeList)) {
                for (ViidApe ape : apeList) {
                    ape.setIsOnline(0); // 0表示离线
                }
                // 批量更新采集设备状态
                viidApeService.updateBatch(apeList);
                log.info("系统启动时更新所有采集设备状态为离线，共更新{}个设备", apeList.size());
            } else {
                log.info("系统启动时未发现任何采集设备");
            }
        } catch (Exception e) {
            log.error("系统启动时更新所有设备状态为离线失败", e);
        }
    }

    /**
     * 判断设备是否已注册
     *
     * @param deviceId 设备ID
     * @return 是否已注册
     */
    public boolean isDeviceRegistered(String deviceId) {
        boolean isRegistered = registeredDeviceIds.contains(deviceId);
        if (!isRegistered) {
            log.info("设备{}未注册，请先注册设备", deviceId);
        }
        return isRegistered;
    }

    /**
     * 获取设备最后活跃时间
     *
     * @param deviceId 设备ID
     * @return 最后活跃时间
     */
    public Date getDeviceLastActiveTime(String deviceId) {
        return deviceLastActiveTime.get(deviceId);
    }

    /**
     * 更新设备最后活跃时间
     *
     * @param deviceId 设备ID
     */
    public void updateDeviceLastActiveTime(String deviceId) {
        deviceLastActiveTime.put(deviceId, new Date());
        updateDeviceStatus(deviceId, RegisterStatusEnum.REGISTERED.getCode(), OnlineStatusEnum.ONLINE.getCode());
    }

    /**
     * 移除设备相关信息（用于注销）
     *
     * @param deviceId 设备ID
     */
    public void removeDevice(String deviceId) {
        updateDeviceStatus(deviceId, RegisterStatusEnum.UNREGISTERED.getCode(), OnlineStatusEnum.OFFLINE.getCode());
        log.info("设备注销成功：{}", deviceId);
    }

    /**
     * 添加已注册设备
     *
     * @param deviceId 设备ID
     */
    public void addRegisteredDevice(String deviceId) {
        updateDeviceStatus(deviceId, RegisterStatusEnum.REGISTERED.getCode(), OnlineStatusEnum.ONLINE.getCode());
        deviceLastActiveTime.put(deviceId, new Date());
        log.info("设备注册成功：{}", deviceId);
    }

}