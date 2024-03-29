package com.example.springcloud.springclouddashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard.class, args);
    }
}
