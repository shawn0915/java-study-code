package com.shawnyan.commonservice;

import com.shawnyan.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shawnyan
 */
@SpringBootApplication
public class CommonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}
