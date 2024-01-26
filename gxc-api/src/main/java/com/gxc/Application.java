package com.gxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Green写代码
 * @date 2023-12-27 14:55
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.gxc.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
