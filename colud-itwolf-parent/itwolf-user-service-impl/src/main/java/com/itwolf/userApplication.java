package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/12/15 14:24.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableSwagger2
public class userApplication {
    public static void main(String[] args) {
        SpringApplication.run(userApplication.class);
    }

    /*@LoadBalanced
    @Bean
    public RestTemplate getRestTempt(){
        return new RestTemplate();
    }*/

}
