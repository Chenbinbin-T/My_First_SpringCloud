package com.example.springclouddept8004.controller;

import com.example.springclouddept8004.service.DeptService;
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

    // 获取配置的信息，得到具体的微服务
    @Resource
    private DiscoveryClient client;


    @PostMapping("/dept/add")
    @ResponseBody
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") int id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    @ResponseBody
    public List<Dept> addDept() {
        return deptService.queryAll();
    }

    // 注册进微服务后，获取信息
    @GetMapping("/dept/info")
    @ResponseBody
    public Object discovery() {
        // 获得微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        // 得到具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-DEPT-8002");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId()
            );
        }
        return this.client;
    }
}
