package com.lssjzmn;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDubbo
@EnableCaching
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.lssjzmn"})
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class SpringbootDubboDeptServiceApplicaiton {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringbootDubboDeptServiceApplicaiton.class, args);
    }

}
