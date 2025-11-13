package com.fliad.dahua.service.impl;

import com.fliad.dahua.dao.entity.DahuaCamera;
import com.fliad.dahua.service.DahuaCameraService;
import com.fliad.dev.modular.file.provider.DevFileApiProvider;
import com.netsdk.alarm.DahuaAlarmManager;
import com.netsdk.alarm.DahuaAnalyzerDataCallBack;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 大华摄像头初始化运行器
 */
@Component
public class DahuaCameraInitRunner implements LifecycleBean {
    private static final Logger log = LoggerFactory.getLogger(DahuaCameraInitRunner.class);

    private static final String DEVICE_TYPE = "dahua";

    @Inject
    private DahuaCameraService dahuaCameraService;
    @Inject
    DevFileApiProvider devFileApiProvider;
    DahuaAlarmManager dahuaAlarmManager = null;

    /**
     * 系统启动完成后执行初始化
     */
    @Override
    public void start() throws Throwable {
        log.info("开始初始化大华设备...");

        // 查询所有启用的设备
        IEntityDao<com.fliad.dahua.dao.entity.DahuaCamera> dahuaCameraDao = DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class);
        QueryBean query = new QueryBean();
        query.addFilterCondition(DahuaCamera.PROP_NAME_enableStatus, "eq", "1");
        List<com.fliad.dahua.dao.entity.DahuaCamera> cameras = dahuaCameraDao.findAllByQuery(query);
        if (cameras.isEmpty()) {
            log.info("未配置大华摄像头设备，跳过初始化");
            return;
        }

        log.info("共找到 {} 个大华摄像头设备", cameras.size());

        // 初始化设备管理器
        boolean sdkInitialized = DahuaAlarmManager.initSDK(null, null);
        if (!sdkInitialized) {
            return;
        }
        log.info("大华设备管理器初始化成功");

        dahuaAlarmManager = new DahuaAlarmManager();

        dahuaAlarmManager.setAnalyzerDataCallback(new DahuaAnalyzerDataCallBack(dahuaAlarmManager, devFileApiProvider));

        // 初始化所有设备
        for (com.fliad.dahua.dao.entity.DahuaCamera camera : cameras) {
            try {
                String deviceId = camera.getId_();
                String deviceNumber = camera.getDeviceId(); // 设备编号
                String ip = camera.getIpAddr();

                // 添加设备到管理器
                dahuaAlarmManager.addDevice(
                        camera.getId_(),
                        camera.getDeviceId(),
                        camera.getIpAddr(),
                        camera.getPort(),
                        camera.getUsername(),
                        camera.getPassword()
                );

                // 登录设备
                boolean loggedIn = dahuaAlarmManager.loginDevice(deviceId);
                if (!loggedIn) {
                    continue;
                }

                // 布防
                boolean alarmHandle = dahuaAlarmManager.setupAlarmChan(deviceId);
                if (!alarmHandle) {
                    continue;
                }

                log.info("设备 {} 初始化成功", deviceId);
            } catch (Exception e) {
                log.error("初始化设备 {} 时发生异常", camera.getId_(), e);
            }
        }
    }

    /**
     * 系统停止时执行资源清理
     */
    @Override
    public void stop() throws Throwable {

    }
}
