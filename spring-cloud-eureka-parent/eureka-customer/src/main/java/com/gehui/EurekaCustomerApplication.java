package com.gehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients//开启Feign 权限(basePackages = "com.gehui.feign")(basePackages = "com.gehui.feign")
@EnableDiscoveryClient
public class EurekaCustomerApplication {

    @Bean
    @LoadBalanced //使用负载均衡，使用手写的ribbon需要将此注掉
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }
}
