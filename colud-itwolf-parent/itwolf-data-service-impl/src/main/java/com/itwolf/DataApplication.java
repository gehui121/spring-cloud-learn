package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/12/15 15:26.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableSwagger2
public class DataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class);
    }
}
