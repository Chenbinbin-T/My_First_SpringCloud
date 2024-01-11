package com.example.SpringCloudEureka7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//LoadBalancer和Eureka整合后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaServer // 服务端启动类，可以接受别人的注册
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }
}
