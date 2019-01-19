package com.itwolf.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2018/12/23 14:19.
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CommonApp {
    public static void main(String[] args) {
        SpringApplication.run(CommonApp.class,args);
    }
}
