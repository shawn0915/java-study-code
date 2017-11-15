package com.shawnyan.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnyan
 * @date 2017/11/14 下午7:40
 */
@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot.";
    }

}
