package com.gehui.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/23 16:17.
 **/
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        logger.info("调用hello服务成功,传入的参数是：{}",name);
        return "欢迎" + name + "调用服务" + serverPort;
    }

    @RequestMapping(value = "/hello1")
    public String hello1(){
        logger.info("调用hello服务成功");
        return "欢迎调用服务" + serverPort;
    }
}
