package com.itwolf.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/29 17:46.
 **/
@RestController
public class HelloController{

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello,我是订单服务，请求端口号是： " + serverPort;
    }
}
