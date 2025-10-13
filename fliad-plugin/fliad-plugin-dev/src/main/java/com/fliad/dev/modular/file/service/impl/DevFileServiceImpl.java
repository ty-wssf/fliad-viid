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
package com.fliad.dev.modular.file.service.impl;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.UploadedFile;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.common.prop.CommonProperties;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.common.util.CommonResponseUtil;
import com.fliad.dev.modular.file.entity.DevFile;
import com.fliad.dev.modular.file.enums.DevFileEngineTypeEnum;
import com.fliad.dev.modular.file.mapper.DevFileMapper;
import com.fliad.dev.modular.file.param.DevFileIdParam;
import com.fliad.dev.modular.file.param.DevFileListParam;
import com.fliad.dev.modular.file.param.DevFilePageParam;
import com.fliad.dev.modular.file.param.DevFileUrlListParam;
import com.fliad.dev.modular.file.service.DevFileService;
import com.fliad.dev.modular.file.util.DevFileAliyunUtil;
import com.fliad.dev.modular.file.util.DevFileLocalUtil;
import com.fliad.dev.modular.file.util.DevFileMinIoUtil;
import com.fliad.dev.modular.file.util.DevFileTencentUtil;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * 文件Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:43
 **/
@Component
public class DevFileServiceImpl extends ServiceImpl<DevFileMapper, DevFile> implements DevFileService {

    @Inject
    private CommonProperties commonProperties;

    @Override
    public String uploadReturnId(String engine, UploadedFile file) {
        return this.storageFile(engine, file, true);
    }

    @Override
    public String uploadReturnUrl(String engine, UploadedFile file) {
        return this.storageFile(engine, file, false);
    }

    @Override
    public Page<DevFile> page(DevFilePageParam devFilePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(devFilePageParam.getEngine())) {
            queryWrapper.eq(DevFile::getEngine, devFilePageParam.getEngine());
        }
        if (ObjectUtil.isNotEmpty(devFilePageParam.getSearchKey())) {
            queryWrapper.like(DevFile::getName, devFilePageParam.getSearchKey());
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public List<DevFile> list(DevFileListParam devFileListParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(devFileListParam.getEngine())) {
            queryWrapper.eq(DevFile::getEngine, devFileListParam.getEngine());
        }
        if (ObjectUtil.isNotEmpty(devFileListParam.getSearchKey())) {
            queryWrapper.like(DevFile::getName, devFileListParam.getSearchKey());
        }
        return this.list(queryWrapper);
    }

    @Override
    public void download(DevFileIdParam devFileIdParam, Context ctx) throws IOException {
        DevFile devFile;
        try {
            devFile = this.queryEntity(devFileIdParam.getId());
        } catch (Exception e) {
            CommonResponseUtil.renderError(ctx, e.getMessage());
            return;
        }
        if (!devFile.getEngine().equals(DevFileEngineTypeEnum.LOCAL.getValue())) {
            CommonResponseUtil.renderError(ctx, "非本地文件不支持此方式下载，id值为：" + devFile.getId());
            return;
        }
        File file = FileUtil.file(devFile.getStoragePath());
        if (!FileUtil.exist(file)) {
            CommonResponseUtil.renderError(ctx, "找不到存储的文件，id值为：" + devFile.getId());
            return;
        }
        CommonDownloadUtil.download(devFile.getName(), IoUtil.readBytes(FileUtil.getInputStream(file)), ctx);
    }

    @Override
    public void delete(List<DevFileIdParam> devFileIdParamList) {
        this.removeByIds(CollStreamUtil.toList(devFileIdParamList, DevFileIdParam::getId));
    }

    /**
     * 存储文件
     *
     * @author xuyuxiang
     * @date 2022/6/16 16:24
     **/
    private String storageFile(String engine, UploadedFile file, boolean returnFileId) {

        // 如果引擎为空，默认使用本地
        if (ObjectUtil.isEmpty(engine)) {
            engine = DevFileEngineTypeEnum.LOCAL.getValue();
        }

        // 生成id
        String fileId = IdUtil.getSnowflake().nextIdStr();

        // 存储桶名称
        String bucketName;

        // 定义存储的url，本地文件返回文件实际路径，其他引擎返回网络地址
        String storageUrl;

        // 根据引擎类型执行不同方法
        if (engine.equals(DevFileEngineTypeEnum.LOCAL.getValue())) {

            // 使用固定名称defaultBucketName
            bucketName = "defaultBucketName";
            storageUrl = DevFileLocalUtil.storageFileWithReturnUrl(bucketName, genFileKey(fileId, file), file);
        } else if (engine.equals(DevFileEngineTypeEnum.ALIYUN.getValue())) {

            // 使用阿里云默认配置的bucketName
            bucketName = DevFileAliyunUtil.getDefaultBucketName();
            storageUrl = DevFileAliyunUtil.storageFileWithReturnUrl(bucketName, genFileKey(fileId, file), file);
        } else if (engine.equals(DevFileEngineTypeEnum.TENCENT.getValue())) {

            // 使用腾讯云默认配置的bucketName
            bucketName = DevFileTencentUtil.getDefaultBucketName();
            storageUrl = DevFileTencentUtil.storageFileWithReturnUrl(bucketName, genFileKey(fileId, file), file);
        } else if (engine.equals(DevFileEngineTypeEnum.MINIO.getValue())) {

            // 使用MINIO默认配置的bucketName
            bucketName = DevFileMinIoUtil.getDefaultBucketName();
            storageUrl = DevFileMinIoUtil.storageFileWithReturnUrl(bucketName, genFileKey(fileId, file), file);
        } else {
            throw new CommonException("不支持的文件引擎：{}", engine);
        }

        // 将文件信息保存到数据库
        DevFile devFile = new DevFile();

        // 设置文件id
        devFile.setId(fileId);

        // 设置存储引擎类型
        devFile.setEngine(engine);
        devFile.setBucket(bucketName);
        devFile.setName(file.getName());
        String suffix = ObjectUtil.isNotEmpty(file.getName()) ? StrUtil.subAfter(file.getName(),
                StrUtil.DOT, true) : null;
        devFile.setSuffix(suffix);
        devFile.setSizeKb(Convert.toStr(NumberUtil.div(new BigDecimal(file.getContentSize()), BigDecimal.valueOf(1024))
                .setScale(0, BigDecimal.ROUND_HALF_UP)));
        devFile.setSizeInfo(FileUtil.readableFileSize(file.getContentSize()));
        devFile.setObjName(ObjectUtil.isNotEmpty(devFile.getSuffix()) ? fileId + StrUtil.DOT + devFile.getSuffix() : null);
        // 如果是图片，则压缩生成缩略图
        if (ObjectUtil.isNotEmpty(suffix)) {
            if (isPic(suffix)) {
                try {
                    byte[] bytes = IoUtil.readBytes(file.getContent());
                    devFile.setThumbnail(ImgUtil.toBase64DataUri(ImgUtil.scale(ImgUtil.toImage(bytes),
                            100, 100, null), suffix));
                } catch (Exception ignored) {
                }
            }
        }
        // 存储路径
        devFile.setStoragePath(storageUrl);

        // 定义下载地址
        String downloadUrl;

        // 下载路径，注意：本地文件下载地址设置为下载接口地址 + 文件id
        if (engine.equals(DevFileEngineTypeEnum.LOCAL.getValue())) {
            String apiUrl = commonProperties.getBackendUrl();
            if (ObjectUtil.isEmpty(apiUrl)) {
                throw new CommonException("后端域名地址未正确配置：snowy.config.common.backend-url为空");
            }
            downloadUrl = apiUrl + "/dev/file/download?id=" + fileId;
            devFile.setDownloadPath(downloadUrl);
        } else {
            // 阿里云、腾讯云、MINIO可以直接使用存储地址（公网）作为下载地址
            downloadUrl = storageUrl;
            devFile.setDownloadPath(devFile.getStoragePath());
        }

        this.save(devFile);

        // 如果是返回id则返回文件id
        if (returnFileId) {
            return fileId;
        } else {
            // 否则返回下载地址
            return downloadUrl;
        }
    }

    /**
     * 生成文件的key，格式如 2021/10/11/1377109572375810050.docx
     *
     * @author xuyuxiang
     * @date 2022/4/22 15:58
     **/
    public String genFileKey(String fileId, UploadedFile file) {

        // 获取文件原始名称
        String originalFileName = file.getName();

        // 获取文件后缀
        String fileSuffix = FileUtil.getSuffix(originalFileName);

        // 生成文件的对象名称，格式如:1377109572375810050.docx
        String fileObjectName = fileId + StrUtil.DOT + fileSuffix;

        // 获取日期文件夹，格式如，2021/10/11/
        String dateFolderPath = DateUtil.thisYear() + StrUtil.SLASH +
                (DateUtil.thisMonth() + 1) + StrUtil.SLASH +
                DateUtil.thisDayOfMonth() + StrUtil.SLASH;

        // 返回
        return dateFolderPath + fileObjectName;
    }

    @Override
    public DevFile detail(DevFileIdParam devFileIdParam) {
        return this.queryEntity(devFileIdParam.getId());
    }

    @Override
    public List<DevFile> getFileListByUrlList(DevFileUrlListParam devFileUrlListParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 只查询部分字段
        queryWrapper.select(DevFile::getId, DevFile::getSuffix, DevFile::getDownloadPath, DevFile::getName, DevFile::getThumbnail,
                        DevFile::getSizeKb, DevFile::getSizeInfo, DevFile::getObjName)
                .in(DevFile::getDownloadPath, devFileUrlListParam.getUrlList());
        return this.list(queryWrapper);
    }

    @Override
    public DevFile queryEntity(String id) {
        DevFile devFile = this.getById(id);
        if (ObjectUtil.isEmpty(devFile)) {
            throw new CommonException("文件不存在，id值为：{}", id);
        }
        return devFile;
    }

    /**
     * 根据文件后缀判断是否图片
     *
     * @author xuyuxiang
     * @date 2020/7/6 15:31
     */
    private static boolean isPic(String fileSuffix) {
        fileSuffix = fileSuffix.toLowerCase();
        return ImgUtil.IMAGE_TYPE_GIF.equals(fileSuffix)
                || ImgUtil.IMAGE_TYPE_JPG.equals(fileSuffix)
                || ImgUtil.IMAGE_TYPE_JPEG.equals(fileSuffix)
                || ImgUtil.IMAGE_TYPE_BMP.equals(fileSuffix)
                || ImgUtil.IMAGE_TYPE_PNG.equals(fileSuffix)
                || ImgUtil.IMAGE_TYPE_PSD.equals(fileSuffix);
    }
}
