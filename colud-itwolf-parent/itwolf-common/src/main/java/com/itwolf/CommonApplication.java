package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2018/10/29 17:58.
 **/
@SpringBootApplication
@EnableEurekaClient
public class CommonApplication{
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
