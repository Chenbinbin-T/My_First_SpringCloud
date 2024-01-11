package com.example.springcloudconsumerdept80.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pojo.Dept;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者不应该有service层
    // RestTemplate直接调用就行，注册到Spring中
    // (URL, 传实体:Map, Class<T> ResponseType)
    @Resource
    private RestTemplate restTemplate;

    // 使用LoadBalancer的时候，访问地址应该为一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @GetMapping("/consumer/dept/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") int id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @PostMapping("/consumer/dept/add")
    @ResponseBody
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/list")
    @ResponseBody
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("")
    @ResponseBody
    public String Hello() {
        return "Hello";
    }
}
