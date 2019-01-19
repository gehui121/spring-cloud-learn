package com.itwolf.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2018/12/23 15:33.
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class DataServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(DataServiceApp.class,args);
    }
}
