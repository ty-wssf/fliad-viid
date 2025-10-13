/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.sys.modular.group.provider;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.sys.api.SysGroupApi;
import com.fliad.sys.modular.group.param.SysGroupGrantUserParam;
import com.fliad.sys.modular.group.param.SysGroupIdParam;
import com.fliad.sys.modular.group.service.SysGroupService;

import java.util.List;

/**
 * 用户组API接口提供者
 *
 * @author chengchuanyao
 * @date 2025/1/6 11:35
 */
@Component
public class SysGroupApiProvider implements SysGroupApi {

    @Inject
    private SysGroupService sysGroupService;

    @Override
    public List<String> ownUser(String groupId) {
        SysGroupIdParam sysGroupIdParam = new SysGroupIdParam();
        sysGroupIdParam.setId(groupId);
        return sysGroupService.ownUser(sysGroupIdParam);
    }

    @Override
    public void grantUser(String groupId, List<String> userIdList) {
        SysGroupGrantUserParam sysGroupGrantUserParam = new SysGroupGrantUserParam();
        sysGroupGrantUserParam.setId(groupId);
        sysGroupGrantUserParam.setGrantInfoList(userIdList);
        sysGroupService.grantUser(sysGroupGrantUserParam);
    }
}
