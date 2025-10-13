<div align="center">
    <p align="center">
        <img src="fliad-admin-web/public/img/logo.png" height="150" alt="logo"/>
    </p>
</div>

## 框架介绍

Snowy-Lite（SnowyAdmin Lite版本）是基于Snowy用Solon替换SpringBoot、Flex替换Plus，它的速度更快更清爽，体积更小，当然服务器资源也更节省；更可以说它是一款新秀产品，供大家共同品鉴。

为什么叫Lite版本呢，因为我认为多方面来讲，更加轻量才是重点。

采用Snowy+Solon+Mybatis-Flex+Sa-Token+HuTool 等更多技术开发，注释丰富，代码简洁，开箱即用！

欢迎加入QQ技术群互相解决问题：732230670（已满）、685395081

<p align="center">     
    <p align="center">
        <a href="https://gitee.com/xiaonuobase/snowy">
            <img src="https://gitee.com/xiaonuobase/snowy/badge/star.svg?theme=dark" alt="Gitee star">
        </a>
        <a href="https://gitee.com/xiaonuobase/snowy">
            <img src="https://gitee.com/xiaonuobase/snowy/badge/fork.svg?theme=dark" alt="Gitee fork">
        </a>
        <a href="./LICENSE">
            <img src="https://img.shields.io/badge/license-Apache%202-red" alt="license Apache 2.0">
        </a>
    </p>
</p>

## 快速链接

下载地址：https://gitee.com/xiaonuobase/snowy-lite

演示地址：https://snowy.xiaonuo.vip

前端地址：
<table>
    <tr>
        <td>
            ElementPlus前端
        </td>
        <td>
            AntDesignVue前端
        </td>
    </tr>
    <tr>
        <td>
            <a href="https://xiaonuo.vip/product/detail?id=1811064102788808706" target="_blank"><img src="fliad-admin-web/public/img/elp.png" height="80" alt="logo"/></a>
        </td>
        <td>
            <a href="https://gitee.com/xiaonuobase/snowy/tree/master/snowy-admin-web" target="_blank"><img src="fliad-admin-web/public/img/antdv.png" height="80" alt="logo"/></a>
        </td>
    </tr>
</table>

## 支撑组件及启动

目前Snowy前端可以在上面快速连接中下载，因前端跟Snowy完全一致，所以未单独添加仓库，升级也会随着两个项目同时升

### 前端支撑

| 插件      | 版本  | 用途             |
|---------|-----|----------------|
| node.js | ≥16 | JavaScript运行环境 |

#### 启动前端

```
npm install
```

```
npm run dev
```

### 后端支撑

| 插件    | 版本           | 用途     |
|-------|--------------|--------|
| jdk   | 11 / 17 / 21 | java环境 |
| maven | 最新版          | 包管理工具  |
| redis | 最新版          | 缓存库    |
| mysql | 8.0 / 5.7    | 数据库    |

注：如果在启动该应用时，启动过原版本Snowy，请及时清理redis缓存，因为存储格式不一样。

#### 启动后端

开发工具内配置好maven并在代码中配置数据库即可启动

## 代码结构

Snowy-Lite框架对代码以插件化的模式进行分包，使得包层级结构更加清晰合理，同时降低了耦合度，关于插件模块化开发的规范请查阅文档【SNOWY开源文档——前端手册or后端手册——开发规范】板块。

```
snowy
  |-snowy-common == 基础通用模块
  |-fliad-plugin == 插件包
    |-fliad-plugin-auth == 登录鉴权插件
    |-fliad-plugin-biz == 业务功能插件
    |-fliad-plugin-client == C端功能插件
    |-fliad-plugin-dev == 开发工具插件
    |-fliad-plugin-sys == 系统功能插件
  |-fliad-plugin-api == 插件api包
    |-fliad-plugin-auth-api == 登录鉴权插件api接口
    |-fliad-plugin-biz-api == 业务功能插件api接口
    |-fliad-plugin-client-api == C端功能插件api接口
    |-fliad-plugin-dev-api == 开发工具插件api接口
    |-fliad-plugin-sys-api == 系统功能插件api接口
  |-snowy-web-app == 主启动模块
```

## 分支说明

- master

正式稳定版本，具体版本升级内容看更新标签

- dev

团队开发的分支（代码可能随时会推，不保证运行和使用）

## 视频教程

教程地址（免费开放）：[https://space.bilibili.com/50101698/channel/collectiondetail?sid=739071](https://space.bilibili.com/50101698/channel/collectiondetail?sid=739071)

<img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mhLatA%7D%2F&_etag=1730700699-816553&shareID=-9mhLatA"/>

作者也在上班工作，所以在利用休息时间为大家创作，录制视频的目的也是为各位小伙伴提供文档跟技术交流群聊之外的上手学习资料

> 视频由小诺开源技术团队王同学（每天一点）进行录制

## 架构原理

* 业务架构

<p align="center">
    <img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lQAEoQ%7D%2F&_etag=1730690514-197232&shareID=-9lQAEoQ"/>
</p>

* 应用架构

<p align="center">
    <img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lPMbxA%7D%2F&_etag=1730690514-308767&shareID=-9lPMbxA"/>
</p>

* 数据架构

<p align="center">
    <img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lQja5Q%7D%2F&_etag=1730690514-322422&shareID=-9lQja5Q"/>
</p>

* 技术架构

<p align="center">
    <img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lQxASg%7D%2F&_etag=1730690514-152387&shareID=-9lQxASg"/>
</p>

* 部署架构

<p align="center">
    <img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lRBZAw%7D%2F&_etag=1730690514-222880&shareID=-9lRBZAw"/>
</p>

## 效果展示

<table>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lSg_Dw%7D%2F&_etag=1730384489-1272624&shareID=-9lSg_Dw"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lTCIQQ%7D%2F&_etag=1730384527-354571&shareID=-9lTCIQQ"/></td>
    </tr>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lTUROA%7D%2F&_etag=1730384568-327201&shareID=-9lTUROA"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lTdB3A%7D%2F&_etag=1730384595-160612&shareID=-9lTdB3A"/></td>
    </tr>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lTp1iw%7D%2F&_etag=1730384617-182491&shareID=-9lTp1iw"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lTyI5g%7D%2F&_etag=1730384636-144484&shareID=-9lTyI5g"/></td>
    </tr>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lUAj9A%7D%2F&_etag=1730384732-148422&shareID=-9lUAj9A"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lUWvfg%7D%2F&_etag=1730384836-112114&shareID=-9lUWvfg"/></td>
    </tr>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9lUuk7g%7D%2F&_etag=1730384925-320963&shareID=-9lUuk7g"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mJCOTw%7D%2F&_etag=1730385032-172917&shareID=-9mJCOTw"/></td>
    </tr>
    <tr>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mJSKTQ%7D%2F&_etag=1730385077-142012&shareID=-9mJSKTQ"/></td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mJfjcg%7D%2F&_etag=1730385168-168192&shareID=-9mJfjcg"/></td>
    </tr>
</table>

## 密码分步

| 功能     | 算法类型                 |
|--------|----------------------|
| 登录     | SM2前端加密，后端解密         |
| 登录登出日志 | SM2对登录登出日志做签名完整性保护存储 |
| 操作日志   | SM2对操作日志做签名完整性保护存储   |
| 用户密码   | SM3完整性保护存储，登录时做完整性校验 |
| 用户手机号  | SM4（cbc模式）加解密使用字段脱敏  |

## 官方群聊

QQ技术群：732230670（已满）、685395081

微信技术群：因群达到200人以上，需加微信拉群

<table>
    <tr>
        <td>微信群</td>
        <td><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mUnPEw%7D%2F&_etag=1730699307-193261&shareID=-9mUnPEw" width="120"/></td>
    </tr>
</table>

## 外包开发

如果您（或您公司）有外包开发需求，可以通过联系客服方式，提交您的需求，经过工作量分析，出具合适的报价，合作开发并交付。

本团队具备雄厚的技术人才力量，均跟随小诺团队发展至今，已完全熟练每一处细节代码，您的产品自然也是由Snowy平台进行开发并交付。

1、工期保障
2、源码质量保障
3、节点按时汇报

## 开源团队

小诺开源技术团队荣誉出品，过程中邀请到Sa-Token作者、Solon作者、EasyTrans作者等共同携手助力一同完成此产品的改进落地

| 成员  | 技术 |  昵称   | 
|:---:|:--:|:-----:| 
| 俞宝山 | 全栈 |  俞宝山  | 
| 徐玉祥 | 全栈 | 就是那个锅 | 
| 董夏雨 | 全栈 |  阿董   | 
| 王鹏  | 全栈 | 每天一点  | 
| 陈心雨 | 前端 |   .   | 
| 程传耀 | 全栈 |  初衷   |

## 代码贡献

近期有很多热心开源的使用者陆续为咱们Snowy-Lite框架提交PR或者提出好的建议，基本合格的PR我们都接受，这样您的头像就列入到咱们Snowy-Lite仓库的贡献者列表啦！

如何贡献：

1、fork一份代码至自己的账号下，本地修改您要提的代码，提交至您fork的仓库

2、登录gitee后到Snowy仓库下创建Pull Requests,选择您的仓库到Snowy的dev分支，提交即可

因为dev分支是团队开发分支，并不是统一发版本的测试过的，所以我们建议提代码至dev即可

## 曾获荣誉

🔥 **2021年度OSC中国开源项目评选-最受欢迎项目**

🔥 **2022年度OSC中国开源项目评选-最火热中国开源项目社区**

🔥 **2024 GitCode项目毕业认证-G-Star优秀毕业项目**

🔥 **2024 GitCode开源共创大会-十大新锐项目**

🔥 **2024中国互联网发展创新与投资大赛（开源）-优秀奖**

<table>
    <tr>
        <td style="width: 50%"><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mLM-zg%7D%2F&_etag=1730698398-294375&shareID=-9mLM-zg"/></td>
        <td style="width: 50%"><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9mLtqmQ%7D%2F&_etag=1730698444-77496&shareID=-9mLtqmQ"/></td>
    </tr>
    <tr>
        <td style="width: 50%"><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A-9nmI4yQ%7D%2F&_etag=1730707931-764633&shareID=-9nmI4yQ"/></td>
        <td style="width: 50%"><img src="https://pan.xiaonuo.vip/?explorer/share/fileOut&path=%7BshareItemLink%3A_COsphyQ%7D%2F&_etag=1732688010-447888&shareID=_COsphyQ"/></td>
    </tr>
</table>

## 版权说明

- Snowy生态技术框架全系版本采用 Apache License2.0协议

- 代码可用于个人项目等接私活或企业项目脚手架使用，Snowy全系开源版完全免费

- 二次开发如用于开源竞品请先联系群主沟通，禁止任何变相的二开行为，未经审核视为侵权

- 请不要删除和修改Snowy-Lite源码头部的版权与作者声明及出处
