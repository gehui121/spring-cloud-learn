package com.itwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2018/11/12 22:47.
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class AppConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class);
    }
}
