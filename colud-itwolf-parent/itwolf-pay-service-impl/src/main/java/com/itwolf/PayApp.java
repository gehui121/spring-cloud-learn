package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2018/11/22 9:53.
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
//@EnableHystrixDashboard
public class PayApp {
    public static void main(String[] args) {
        SpringApplication.run(PayApp.class);
    }
}
