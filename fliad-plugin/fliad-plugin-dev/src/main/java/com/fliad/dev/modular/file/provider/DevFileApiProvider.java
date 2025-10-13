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
package com.fliad.dev.modular.file.provider;

import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.UploadedFile;
import com.fliad.dev.api.DevFileApi;
import com.fliad.dev.modular.file.enums.DevFileEngineTypeEnum;
import com.fliad.dev.modular.file.service.DevFileService;


/**
 * 文件API接口提供者
 *
 * @author xuyuxiang
 * @date 2022/6/22 15:32
 **/
@Component
public class DevFileApiProvider implements DevFileApi {

    @Inject
    private DevFileService devFileService;

    @Override
    public String storageFileWithReturnUrlLocal(UploadedFile file) {
        return devFileService.uploadReturnUrl(DevFileEngineTypeEnum.LOCAL.getValue(), file);
    }

    @Override
    public String storageFileWithReturnIdLocal(UploadedFile file) {
        return devFileService.uploadReturnId(DevFileEngineTypeEnum.LOCAL.getValue(), file);
    }

    @Override
    public String storageFileWithReturnUrlAliyun(UploadedFile file) {
        return devFileService.uploadReturnUrl(DevFileEngineTypeEnum.ALIYUN.getValue(), file);
    }

    @Override
    public String storageFileWithReturnIdAliyun(UploadedFile file) {
        return devFileService.uploadReturnId(DevFileEngineTypeEnum.ALIYUN.getValue(), file);
    }

    @Override
    public String storageFileWithReturnUrlTencent(UploadedFile file) {
        return devFileService.uploadReturnUrl(DevFileEngineTypeEnum.TENCENT.getValue(), file);
    }

    @Override
    public String storageFileWithReturnIdTencent(UploadedFile file) {
        return devFileService.uploadReturnId(DevFileEngineTypeEnum.TENCENT.getValue(), file);
    }

    @Override
    public String storageFileWithReturnUrlMinio(UploadedFile file) {
        return devFileService.uploadReturnUrl(DevFileEngineTypeEnum.MINIO.getValue(), file);
    }

    @Override
    public String storageFileWithReturnIdMinio(UploadedFile file) {
        return devFileService.uploadReturnId(DevFileEngineTypeEnum.MINIO.getValue(), file);
    }
}
