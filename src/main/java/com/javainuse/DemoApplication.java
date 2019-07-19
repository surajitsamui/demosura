package com.javainuse;

import ch.qos.logback.classic.LoggerContext;
import com.javainuse.component.TestComponent;
import com.javainuse.component.TestComponent2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
//@EnableAsync
public class DemoApplication {

    private static Logger logger = LoggerFactory.getLogger("com.javainuse");
    
    @Bean
    WebMvcConfigurer configurer(){
        return new WebMvcConfigurerAdapter(){
            @Override
            public void configureAsyncSupport (AsyncSupportConfigurer configurer) {
                ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
                t.setCorePoolSize(10);
                t.setMaxPoolSize(100);
                t.setQueueCapacity(50);
                t.setAllowCoreThreadTimeOut(true);
                t.setKeepAliveSeconds(120);
                t.initialize();
                configurer.setTaskExecutor(t);
            }
        };
    }

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        TestComponent testCom = context.getBean(TestComponent.class);
        testCom.processStep();
        TestComponent2 testCom2 = context.getBean(TestComponent2.class);
        testCom2.processStep();
        String filePath = "/Users/surajit.samui/Desktop/payload_11.json";
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
        String payloadText = readAllBytesJava7(filePath);
        logger.info(payloadText);
        TestComponent2 testCom3 = context.getBean(TestComponent2.class);
        testCom3.processStep();
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.stop();
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
    }

    private static String readAllBytesJava7(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
