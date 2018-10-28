package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2018/10/25 21:50.
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ItWolfProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ItWolfProviderApp.class);
    }
}
