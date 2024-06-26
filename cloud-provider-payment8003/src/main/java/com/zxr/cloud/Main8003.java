package com.zxr.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zxr.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope
public class Main8003 {

    public static void main(String[] args) {
        SpringApplication.run(Main8003.class,args);
    }
}