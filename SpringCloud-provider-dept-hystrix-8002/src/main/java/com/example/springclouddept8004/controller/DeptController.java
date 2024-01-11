package com.example.springclouddept8004.controller;

import com.example.springclouddept8004.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import pojo.Dept;

import javax.annotation.Resource;
import java.util.List;

// 提供Restful服务
@RestController
public class DeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") int id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            // 通过抛出异常来触发Hystrix
            throw new RuntimeException("id=>"+id+"不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    // 触发熔断机制
    public Dept hystrixGet(@PathVariable("id") int id) {
        return new Dept().setId(id).setName("id=>"+id+"不存在该用户，或者信息无法找到@Hystrix").setDb_source("no this database in MySQL");
    }
}
