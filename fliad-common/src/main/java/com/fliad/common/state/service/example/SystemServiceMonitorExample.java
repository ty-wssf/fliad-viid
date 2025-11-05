package com.fliad.common.state.service.example;

import com.fliad.common.state.DeviceStateManager;
import com.fliad.common.state.service.ServiceMonitor;
import com.fliad.common.state.service.ServiceStarter;
import com.fliad.common.state.service.ServiceStateListener;
import org.noear.solon.Solon;
import org.noear.solon.core.bean.LifecycleBean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 系统服务监控示例
 * 展示如何使用ServiceMonitor监控和重启服务
 *
 * @author lingma
 * @date 2025/11/05
 */
public class SystemServiceMonitorExample implements LifecycleBean {

    private ServiceMonitor serviceMonitor;
    private final AtomicBoolean databaseServiceRunning = new AtomicBoolean(true);
    private final AtomicBoolean webServiceRunning = new AtomicBoolean(true);

    @Override
    public void start() throws Throwable {
        // 获取设备状态管理器Bean
        DeviceStateManager deviceStateManager = Solon.context().getBean(DeviceStateManager.class);
        
        // 创建服务监控器
        serviceMonitor = new ServiceMonitor(deviceStateManager);
        
        // 启动服务监控器
        serviceMonitor.start();
        
        // 注册服务监听器
        serviceMonitor.registerServiceListener("database", new ServiceStateListener() {
            @Override
            public boolean isServiceRunning(String serviceName) {
                System.out.println("检查数据库服务状态: " + (databaseServiceRunning.get() ? "运行中" : "已停止"));
                return databaseServiceRunning.get();
            }
        });
        
        serviceMonitor.registerServiceListener("web", new ServiceStateListener() {
            @Override
            public boolean isServiceRunning(String serviceName) {
                System.out.println("检查Web服务状态: " + (webServiceRunning.get() ? "运行中" : "已停止"));
                return webServiceRunning.get();
            }
        });
        
        // 注册服务启动器
        serviceMonitor.registerServiceStarter("database", new ServiceStarter() {
            @Override
            public void startService(String serviceName) throws Exception {
                System.out.println("正在启动数据库服务...");
                // 模拟启动过程
                Thread.sleep(2000);
                databaseServiceRunning.set(true);
                System.out.println("数据库服务启动完成");
            }
        });
        
        serviceMonitor.registerServiceStarter("web", new ServiceStarter() {
            @Override
            public void startService(String serviceName) throws Exception {
                System.out.println("正在启动Web服务...");
                // 模拟启动过程
                Thread.sleep(3000);
                webServiceRunning.set(true);
                System.out.println("Web服务启动完成");
            }
        });
        
        // 启动交互式命令行
        startInteractiveConsole();
    }

    @Override
    public void stop() throws Throwable {
        if (serviceMonitor != null) {
            serviceMonitor.stop();
        }
    }
    
    private void startInteractiveConsole() {
        System.out.println("=== 服务监控示例 ===");
        System.out.println("可用命令:");
        System.out.println("  db-stop    - 停止数据库服务");
        System.out.println("  db-start   - 启动数据库服务");
        System.out.println("  web-stop   - 停止Web服务");
        System.out.println("  web-start  - 启动Web服务");
        System.out.println("  status     - 查看所有服务状态");
        System.out.println("  quit       - 退出程序");
        System.out.println("==================");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if ("quit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                
                handleCommand(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("程序退出");
    }
    
    private void handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "db-stop":
                databaseServiceRunning.set(false);
                System.out.println("数据库服务已停止");
                break;
            case "db-start":
                databaseServiceRunning.set(true);
                System.out.println("数据库服务已启动");
                break;
            case "web-stop":
                webServiceRunning.set(false);
                System.out.println("Web服务已停止");
                break;
            case "web-start":
                webServiceRunning.set(true);
                System.out.println("Web服务已启动");
                break;
            case "status":
                System.out.println("=== 服务状态 ===");
                System.out.println("数据库服务: " + (databaseServiceRunning.get() ? "运行中" : "已停止"));
                System.out.println("Web服务: " + (webServiceRunning.get() ? "运行中" : "已停止"));
                System.out.println("===============");
                break;
            default:
                System.out.println("未知命令: " + command);
                System.out.println("请输入有效命令或 'quit' 退出");
        }
    }
}