package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Administrator on 2018/12/5 20:51.
 **/
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class DashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApp.class);
    }
}
