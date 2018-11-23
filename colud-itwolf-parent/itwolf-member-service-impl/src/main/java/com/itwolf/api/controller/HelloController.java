package com.itwolf.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/29 17:40.
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello,我是会员服务，请求端口号是： " + serverPort;
    }

}
