package com.example.springclouddept8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
@EnableEurekaClient // 注册到Eureka中
@EnableDiscoveryClient // 发现自己
public class SpringCloudDept8002Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDept8002Application.class, args);
    }

}
