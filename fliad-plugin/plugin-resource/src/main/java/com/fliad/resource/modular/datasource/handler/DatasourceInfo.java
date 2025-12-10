package com.fliad.resource.modular.datasource.handler;

/**
 * 数据源信息包装类
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class DatasourceInfo {
    private final String id;
    private final String title;
    private final String type;
    private final String subscribeDetail;
    private final String content;
    private final String scriptFilter;

    public DatasourceInfo(String id, String title, String type, String subscribeDetail, String content, String scriptFilter) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.subscribeDetail = subscribeDetail;
        this.content = content;
        this.scriptFilter = scriptFilter;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getSubscribeDetail() {
        return subscribeDetail;
    }

    public String getContent() {
        return content;
    }

    public String getScriptFilter() {
        return scriptFilter;
    }
}