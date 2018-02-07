package com.softwore.zgd.dubbo.search.config;

import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

/**
 * @author 风骚的GRE
 * @Description 基于注解配置
 * @date 2018/2/5.
 */
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
@PropertySource({"classpath:application.properties"})
@ComponentScan(value = "com.softwore.zgd.dubbo.search")
public class ApplicationConfig  implements AsyncConfigurer,SchedulingConfigurer {
    private static Logger logger = Logger.getLogger(ApplicationConfig.class.getName());
    @Override
    public Executor getAsyncExecutor() {
        return null;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    }

    public static void main(String[] args) {

    }
}
