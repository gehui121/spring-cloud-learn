package com.mayikt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName WeiXinApp
 * @Description
 * @Author Administrator
 * @Date 2019/1/19 13:49
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class WeiXinApp {
    public static void main(String[] args) {
        SpringApplication.run(WeiXinApp.class);
    }
}
