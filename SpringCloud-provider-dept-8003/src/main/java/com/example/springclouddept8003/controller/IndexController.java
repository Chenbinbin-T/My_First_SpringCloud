package com.example.springclouddept8003.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("")
    @ResponseBody
    public String Hello() {
        return "Hello";
    }
}
