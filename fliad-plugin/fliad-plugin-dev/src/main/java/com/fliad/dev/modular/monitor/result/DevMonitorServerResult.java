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
package com.fliad.dev.modular.monitor.result;

import io.swagger.annotations.ApiModelProperty;


/**
 * 服务器监控结果
 *
 * @author xuyuxiang
 * @date 2022/9/1 16:00
 */
public class DevMonitorServerResult {

    /* ==============概览数据============ */
    /** CPU信息 */
    @ApiModelProperty(value = "CPU信息", position = 1)
    private DevMonitorCpuInfo devMonitorCpuInfo;

    /** 内存信息 */
    @ApiModelProperty(value = "内存信息", position = 2)
    private DevMonitorMemoryInfo devMonitorMemoryInfo;

    /** 存储信息 */
    @ApiModelProperty(value = "存储信息", position = 3)
    private DevMonitorStorageInfo devMonitorStorageInfo;

    /** 网络信息 */
    @ApiModelProperty(value = "网络信息", position = 4)
    private DevMonitorNetworkInfo devMonitorNetworkInfo;

    /* ==============服务器数据============ */
    /** 服务器信息 */
    @ApiModelProperty(value = "服务器信息", position = 5)
    private DevMonitorServerInfo devMonitorServerInfo;

    /* ==============JVM数据============ */
    /** JVM信息 */
    @ApiModelProperty(value = "JVM信息", position = 6)
    private DevMonitorJvmInfo devMonitorJvmInfo;

    /**
     * CPU信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorCpuInfo {

        /** CPU名称 */
        @ApiModelProperty(value = "CPU名称", position = 1)
        private String cpuName;

        /** CPU数量 */
        @ApiModelProperty(value = "CPU数量", position = 2)
        private String cpuNum;

        /** CPU物理核心数 */
        @ApiModelProperty(value = "CPU物理核心数", position = 3)
        private String cpuPhysicalCoreNum;

        /** CPU逻辑核心数 */
        @ApiModelProperty(value = "CPU逻辑核心数", position = 4)
        private String cpuLogicalCoreNum;

        /** CPU系统使用率 */
        @ApiModelProperty(value = "CPU系统使用率", position = 5)
        private String cpuSysUseRate;

        /** CPU用户使用率 */
        @ApiModelProperty(value = "CPU用户使用率", position = 6)
        private String cpuUserUseRate;

        /** CPU当前总使用率 */
        @ApiModelProperty(value = "CPU当前总使用率", position = 7)
        private Double cpuTotalUseRate;

        /** CPU当前等待率 */
        @ApiModelProperty(value = "CPU当前等待率", position = 8)
        private String cpuWaitRate;

        /** CPU当前空闲率 */
        @ApiModelProperty(value = "CPU当前空闲率", position = 9)
        private String cpuFreeRate;

        public String getCpuName() {
            return cpuName;
        }

        public void setCpuName(String cpuName) {
            this.cpuName = cpuName;
        }

        public String getCpuNum() {
            return cpuNum;
        }

        public void setCpuNum(String cpuNum) {
            this.cpuNum = cpuNum;
        }

        public String getCpuPhysicalCoreNum() {
            return cpuPhysicalCoreNum;
        }

        public void setCpuPhysicalCoreNum(String cpuPhysicalCoreNum) {
            this.cpuPhysicalCoreNum = cpuPhysicalCoreNum;
        }

        public String getCpuLogicalCoreNum() {
            return cpuLogicalCoreNum;
        }

        public void setCpuLogicalCoreNum(String cpuLogicalCoreNum) {
            this.cpuLogicalCoreNum = cpuLogicalCoreNum;
        }

        public String getCpuSysUseRate() {
            return cpuSysUseRate;
        }

        public void setCpuSysUseRate(String cpuSysUseRate) {
            this.cpuSysUseRate = cpuSysUseRate;
        }

        public String getCpuUserUseRate() {
            return cpuUserUseRate;
        }

        public void setCpuUserUseRate(String cpuUserUseRate) {
            this.cpuUserUseRate = cpuUserUseRate;
        }

        public Double getCpuTotalUseRate() {
            return cpuTotalUseRate;
        }

        public void setCpuTotalUseRate(Double cpuTotalUseRate) {
            this.cpuTotalUseRate = cpuTotalUseRate;
        }

        public String getCpuWaitRate() {
            return cpuWaitRate;
        }

        public void setCpuWaitRate(String cpuWaitRate) {
            this.cpuWaitRate = cpuWaitRate;
        }

        public String getCpuFreeRate() {
            return cpuFreeRate;
        }

        public void setCpuFreeRate(String cpuFreeRate) {
            this.cpuFreeRate = cpuFreeRate;
        }
    }

    /**
     * 内存信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorMemoryInfo {

        /** 内存总量 */
        @ApiModelProperty(value = "内存总量", position = 1)
        private String memoryTotal;

        /** 内存已用 */
        @ApiModelProperty(value = "内存已用", position = 2)
        private String memoryUsed;

        /** 内存剩余 */
        @ApiModelProperty(value = "内存剩余", position = 3)
        private String memoryFree;

        /** 内存使用率 */
        @ApiModelProperty(value = "内存使用率", position = 4)
        private Double memoryUseRate;

        public String getMemoryTotal() {
            return memoryTotal;
        }

        public void setMemoryTotal(String memoryTotal) {
            this.memoryTotal = memoryTotal;
        }

        public String getMemoryUsed() {
            return memoryUsed;
        }

        public void setMemoryUsed(String memoryUsed) {
            this.memoryUsed = memoryUsed;
        }

        public String getMemoryFree() {
            return memoryFree;
        }

        public void setMemoryFree(String memoryFree) {
            this.memoryFree = memoryFree;
        }

        public Double getMemoryUseRate() {
            return memoryUseRate;
        }

        public void setMemoryUseRate(Double memoryUseRate) {
            this.memoryUseRate = memoryUseRate;
        }
    }

    /**
     * 存储信息
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorStorageInfo {

        /** 存储总量 */
        @ApiModelProperty(value = "存储总量", position = 1)
        private String storageTotal;

        /** 存储已用 */
        @ApiModelProperty(value = "存储已用", position = 2)
        private String storageUsed;

        /** 存储剩余 */
        @ApiModelProperty(value = "存储剩余", position = 3)
        private String storageFree;

        /** 存储使用率 */
        @ApiModelProperty(value = "存储使用率", position = 4)
        private Double storageUseRate;

        public String getStorageTotal() {
            return storageTotal;
        }

        public void setStorageTotal(String storageTotal) {
            this.storageTotal = storageTotal;
        }

        public String getStorageUsed() {
            return storageUsed;
        }

        public void setStorageUsed(String storageUsed) {
            this.storageUsed = storageUsed;
        }

        public String getStorageFree() {
            return storageFree;
        }

        public void setStorageFree(String storageFree) {
            this.storageFree = storageFree;
        }

        public Double getStorageUseRate() {
            return storageUseRate;
        }

        public void setStorageUseRate(Double storageUseRate) {
            this.storageUseRate = storageUseRate;
        }
    }

    /**
     * 网络信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorNetworkInfo {

        /** 上行速率 */
        @ApiModelProperty(value = "上行速率", position = 1)
        private String upLinkRate;

        /** 下行速率 */
        @ApiModelProperty(value = "下行速率", position = 2)
        private String downLinkRate;

        public String getUpLinkRate() {
            return upLinkRate;
        }

        public void setUpLinkRate(String upLinkRate) {
            this.upLinkRate = upLinkRate;
        }

        public String getDownLinkRate() {
            return downLinkRate;
        }

        public void setDownLinkRate(String downLinkRate) {
            this.downLinkRate = downLinkRate;
        }
    }

    /**
     * 服务器信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorServerInfo {

        /** 服务器名称 */
        @ApiModelProperty(value = "服务器名称", position = 1)
        private String serverName;

        /** 服务器操作系统 */
        @ApiModelProperty(value = "服务器操作系统", position = 2)
        private String serverOs;

        /** 服务器IP */
        @ApiModelProperty(value = "服务器IP", position = 3)
        private String serverIp;

        /** 服务器架构 */
        @ApiModelProperty(value = "服务器架构", position = 4)
        private String serverArchitecture;

        public String getServerName() {
            return serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }

        public String getServerOs() {
            return serverOs;
        }

        public void setServerOs(String serverOs) {
            this.serverOs = serverOs;
        }

        public String getServerIp() {
            return serverIp;
        }

        public void setServerIp(String serverIp) {
            this.serverIp = serverIp;
        }

        public String getServerArchitecture() {
            return serverArchitecture;
        }

        public void setServerArchitecture(String serverArchitecture) {
            this.serverArchitecture = serverArchitecture;
        }
    }

    /**
     * JVM信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    public static class DevMonitorJvmInfo {

        /** JVM名称 */
        @ApiModelProperty(value = "JVM名称", position = 1)
        private String jvmName;

        /** JVM版本 */
        @ApiModelProperty(value = "JVM版本", position = 2)
        private String jvmVersion;

        /** JVM总分配内存 */
        @ApiModelProperty(value = "JVM总分配内存", position = 3)
        private String jvmMemoryTotal;

        /** JVM已用内存 */
        @ApiModelProperty(value = "JVM已用内存", position = 4)
        private String jvmMemoryUsed;

        /** JVM剩余内存 */
        @ApiModelProperty(value = "JVM剩余内存", position = 5)
        private String jvmMemoryFree;

        /** JVM内存使用率 */
        @ApiModelProperty(value = "JVM内存使用率", position = 6)
        private Double jvmUseRate;

        /** JVM启动时间 */
        @ApiModelProperty(value = "JVM启动时间", position = 7)
        private String jvmStartTime;

        /** JVM运行时长 */
        @ApiModelProperty(value = "JVM运行时长", position = 8)
        private String jvmRunTime;

        /** Java版本 */
        @ApiModelProperty(value = "Java版本", position = 9)
        private String javaVersion;

        /** Java安装路径 */
        @ApiModelProperty(value = "Java安装路径", position = 10)
        private String javaPath;

        public String getJvmName() {
            return jvmName;
        }

        public void setJvmName(String jvmName) {
            this.jvmName = jvmName;
        }

        public String getJvmVersion() {
            return jvmVersion;
        }

        public void setJvmVersion(String jvmVersion) {
            this.jvmVersion = jvmVersion;
        }

        public String getJvmMemoryTotal() {
            return jvmMemoryTotal;
        }

        public void setJvmMemoryTotal(String jvmMemoryTotal) {
            this.jvmMemoryTotal = jvmMemoryTotal;
        }

        public String getJvmMemoryUsed() {
            return jvmMemoryUsed;
        }

        public void setJvmMemoryUsed(String jvmMemoryUsed) {
            this.jvmMemoryUsed = jvmMemoryUsed;
        }

        public String getJvmMemoryFree() {
            return jvmMemoryFree;
        }

        public void setJvmMemoryFree(String jvmMemoryFree) {
            this.jvmMemoryFree = jvmMemoryFree;
        }

        public Double getJvmUseRate() {
            return jvmUseRate;
        }

        public void setJvmUseRate(Double jvmUseRate) {
            this.jvmUseRate = jvmUseRate;
        }

        public String getJvmStartTime() {
            return jvmStartTime;
        }

        public void setJvmStartTime(String jvmStartTime) {
            this.jvmStartTime = jvmStartTime;
        }

        public String getJvmRunTime() {
            return jvmRunTime;
        }

        public void setJvmRunTime(String jvmRunTime) {
            this.jvmRunTime = jvmRunTime;
        }

        public String getJavaVersion() {
            return javaVersion;
        }

        public void setJavaVersion(String javaVersion) {
            this.javaVersion = javaVersion;
        }

        public String getJavaPath() {
            return javaPath;
        }

        public void setJavaPath(String javaPath) {
            this.javaPath = javaPath;
        }
    }

    public DevMonitorCpuInfo getDevMonitorCpuInfo() {
        return devMonitorCpuInfo;
    }

    public void setDevMonitorCpuInfo(DevMonitorCpuInfo devMonitorCpuInfo) {
        this.devMonitorCpuInfo = devMonitorCpuInfo;
    }

    public DevMonitorMemoryInfo getDevMonitorMemoryInfo() {
        return devMonitorMemoryInfo;
    }

    public void setDevMonitorMemoryInfo(DevMonitorMemoryInfo devMonitorMemoryInfo) {
        this.devMonitorMemoryInfo = devMonitorMemoryInfo;
    }

    public DevMonitorStorageInfo getDevMonitorStorageInfo() {
        return devMonitorStorageInfo;
    }

    public void setDevMonitorStorageInfo(DevMonitorStorageInfo devMonitorStorageInfo) {
        this.devMonitorStorageInfo = devMonitorStorageInfo;
    }

    public DevMonitorNetworkInfo getDevMonitorNetworkInfo() {
        return devMonitorNetworkInfo;
    }

    public void setDevMonitorNetworkInfo(DevMonitorNetworkInfo devMonitorNetworkInfo) {
        this.devMonitorNetworkInfo = devMonitorNetworkInfo;
    }

    public DevMonitorServerInfo getDevMonitorServerInfo() {
        return devMonitorServerInfo;
    }

    public void setDevMonitorServerInfo(DevMonitorServerInfo devMonitorServerInfo) {
        this.devMonitorServerInfo = devMonitorServerInfo;
    }

    public DevMonitorJvmInfo getDevMonitorJvmInfo() {
        return devMonitorJvmInfo;
    }

    public void setDevMonitorJvmInfo(DevMonitorJvmInfo devMonitorJvmInfo) {
        this.devMonitorJvmInfo = devMonitorJvmInfo;
    }
}
