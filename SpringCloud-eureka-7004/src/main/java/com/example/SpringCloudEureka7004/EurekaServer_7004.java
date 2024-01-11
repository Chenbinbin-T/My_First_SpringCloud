package com.example.SpringCloudEureka7004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 服务端启动类，可以接受别人的注册
public class EurekaServer_7004 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7004.class, args);
    }
}
