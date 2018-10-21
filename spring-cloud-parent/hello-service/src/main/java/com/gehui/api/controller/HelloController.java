package com.gehui.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/19 11:13.
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverId;

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        System.out.println("HelloWorld 欢迎你 ：" + name + serverId);
        return "欢迎来到Hello项目" + name + "请求的服务是：" + serverId;
    }
}
