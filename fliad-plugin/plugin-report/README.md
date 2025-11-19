# fliad-plugin-report 报表插件

基于NopReport报表引擎的报表插件，支持生成XLSX、HTML等多种格式的报表。

## 功能特性

1. 支持生成XLSX格式报表
2. 支持生成HTML格式报表
3. 提供REST API接口供其他模块调用
4. 支持自定义报表模板
5. 支持复杂数据结构的报表生成
6. 提供Swagger API文档支持

## 使用方法

### 1. 添加依赖

在需要使用报表功能的模块中添加以下依赖：

```xml
<dependency>
    <groupId>com.fliad</groupId>
    <artifactId>fliad-plugin-report</artifactId>
    <version>0.1.0</version>
</dependency>
```

### 3. API文档配置

在配置文件中添加以下配置以启用API文档：

```yaml
swagger:
  enabled: true
  basic:
    username: admin
    password: admin
```

访问 `http://localhost:8080/doc.html` 查看API文档。

### 2. API接口

#### 生成XLSX报表

```
POST /report/xlsx

参数:
- templatePath: 报表模板路径
- data: 报表数据（JSON格式）

返回:
- 生成的XLSX报表文件
```

#### 生成HTML报表

```
POST /report/html

参数:
- templatePath: 报表模板路径
- data: 报表数据（JSON格式）

返回:
- 生成的HTML报表文件
```

### 3. Java服务调用

可以直接注入ReportService来生成报表：

```java
@Inject
private ReportService reportService;

// 生成XLSX报表文件
reportService.generateXlsxReport(templatePath, data, outputFile);

// 生成HTML报表文件
reportService.generateHtmlReport(templatePath, data, outputFile);

// 生成报表字节数组
byte[] xlsxBytes = reportService.generateXlsxReportBytes(templatePath, data);
byte[] htmlBytes = reportService.generateHtmlReportBytes(templatePath, data);
```

## 报表模板

报表模板需要放在resources目录下，支持`.xpt.xlsx`格式的模板文件。

示例模板路径：`/reports/sample.xpt.xlsx`

## 数据格式

报表数据以JSON格式传递，支持复杂嵌套结构。

示例数据：
```json
{
  "title": "销售报表",
  "date": "2025-10-26",
  "items": [
    {
      "name": "产品A",
      "quantity": 100,
      "price": 50.00
    },
    {
      "name": "产品B",
      "quantity": 200,
      "price": 30.00
    }
  ]
}
```