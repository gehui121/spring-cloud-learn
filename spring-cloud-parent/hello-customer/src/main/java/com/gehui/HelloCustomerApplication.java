package com.gehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //用于发现与注册服务
public class HelloCustomerApplication {

    /**
     * @Bean 实例化restTemplate实例，用于发送Http请求，
     * @LoadBalanced 依赖ribbo用于支持客户端负载均衡，通过实例名进行发送请求的，否则报错xxxmember
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloCustomerApplication.class, args);
    }
}
