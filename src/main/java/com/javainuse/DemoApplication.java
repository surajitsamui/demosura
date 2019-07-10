package com.javainuse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class DemoApplication {

 
//    private static final Logger logger = LogManager.getLogger(DemoApplication.class);
    private static Logger trxLogger = LoggerFactory.getLogger("com.javainuse");

    public static void main(String[] args) {
        String filePath = "/Users/surajit.samui/Desktop/payload_1.json";
        System.out.println(readAllBytesJava7( filePath ) );
        
        String payloadText=readAllBytesJava7( filePath );
//        System.out.println(payloadText);
        log.info("Hi Surajit Samui world");
        SpringApplication.run(DemoApplication.class, args);
        log.info("Hi hello world");
        log.debug("Hello, I'm DEBUG message.");
        log.info("Hello, I'm INFO message.");
        log.warn("Hello, I'm WARN message.");
        log.error("Hello, I'm ERROR message.");
        trxLogger.info("completed");
        System.out.println(new Date());
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
        
    }
    
    private static String readAllBytesJava7(String filePath)
    {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 
        return content;
    }

}
