package com.itwolf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/29 17:40.
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello：  " + name  + "服务端口号： " + serverPort;
    }

}
