package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.fliad.common.listener.AbstractCommonDataChangeListener;
import com.fliad.common.pojo.CommonResult;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HTTP数据源处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class HTTPDatasourceHandler extends AbstractCommonDataChangeListener implements DatasourceHandler {
    private static final Logger log = LoggerFactory.getLogger(HTTPDatasourceHandler.class);

    // 存储HTTP接口处理器
    private final Map<String, Handler> httpEndpointHandlers = new ConcurrentHashMap<>();

    @Override
    public void doUpdateWithData(String dataType, JSONObject jsonObject) {
        // 更新事件
    }

    @Override
    public void initConnection(ResourceDatasource datasource) {
        initHttpEndpoint(datasource);
    }

    @Override
    public void closeConnection(String datasourceId) {
        // HTTP端点在应用关闭时自动清理，此处只需移除引用
        httpEndpointHandlers.remove(datasourceId);
        log.info("移除HTTP端点处理器引用，数据源ID：{}", datasourceId);
    }

    @Override
    public String getSupportedType() {
        return "http";
    }

    /**
     * 初始化 HTTP 接口端点
     *
     * @param datasource 数据源实体
     */
    private void initHttpEndpoint(ResourceDatasource datasource) {
        try {
            // 解析 HTTP 配置
            String content = datasource.getContent();
            if (StrUtil.isBlank(content)) {
                log.warn("HTTP数据源配置内容为空，数据源ID：{}", datasource.getId());
                return;
            }

            ONode config = ONode.load(handleEscapeCharacters(content));
            String path = config.get("path").getString();
            String method = config.get("method").getString();

            log.info("注册HTTP接口：path={}, method={}", path, method);

            // 创建处理器
            Handler handler = new HttpEndpointHandler(datasource, config);

            // 注册路由
            Solon.app().router().add(path, handler);

            // 存储处理器引用
            httpEndpointHandlers.put(datasource.getId(), handler);

            log.info("HTTP 接口注册完成，数据源ID：{}，路径：{}", datasource.getId(), path);
        } catch (Exception e) {
            log.error("注册 HTTP 接口失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * HTTP 接口处理器
     */
    private static class HttpEndpointHandler implements Handler {
        private final ResourceDatasource datasource;
        private final ONode config;

        public HttpEndpointHandler(ResourceDatasource datasource, ONode config) {
            this.datasource = datasource;
            this.config = config;
        }

        @Override
        public void handle(Context ctx) throws Throwable {
            log.info("处理HTTP请求，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());

            // 获取请求体
            String requestBody = ctx.body();

            // 返回成功响应
            ctx.status(200);
            ctx.render(CommonResult.ok());
        }
    }

    /**
     * 处理字符串中的转义字符
     *
     * @param jsonStr 包含可能转义字符的JSON字符串
     * @return 处理后的JSON字符串
     */
    private String handleEscapeCharacters(String jsonStr) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return jsonStr;
        }

        // 先尝试直接解析
        if (isValidJson(jsonStr)) {
            return jsonStr;
        }

        // 尝试不同的策略来修复转义字符
        String[] strategies = {
                jsonStr.replace("\\\"", "\""),           // 将 \" 替换为 "
                jsonStr.replace("\\\\", "\\"),           // 将 \\ 替换为 \
                jsonStr.replace("\\\"", "\"").replace("\\\\", "\\"),  // 组合策略1
                jsonStr.replace("\\\\\"", "\"").replace("\\\\'", "'"), // 组合策略2
        };

        // 尝试每种策略，找到第一个能生成有效JSON的
        for (String strategy : strategies) {
            if (isValidJson(strategy)) {
                return strategy;
            }
        }

        // 如果所有策略都失败，返回原始字符串
        return jsonStr;
    }

    /**
     * 检查字符串是否为有效的JSON
     *
     * @param jsonStr 待检查的字符串
     * @return 是否为有效的JSON
     */
    private boolean isValidJson(String jsonStr) {
        try {
            ONode.loadStr(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}