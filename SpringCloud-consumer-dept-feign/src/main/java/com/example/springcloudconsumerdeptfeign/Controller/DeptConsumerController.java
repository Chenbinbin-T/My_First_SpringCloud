package com.example.springcloudconsumerdeptfeign.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pojo.Dept;
import service.DeptClientService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptConsumerController {

    @Resource
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") int id) {
        return service.queryById(id);
    }

    @PostMapping("/consumer/dept/add")
    @ResponseBody
    public boolean add(Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping("/consumer/dept/list")
    @ResponseBody
    public List<Dept> list() {
        return service.queryAll();
    }

    @GetMapping("")
    @ResponseBody
    public String Hello() {
        return "Hello";
    }
}
