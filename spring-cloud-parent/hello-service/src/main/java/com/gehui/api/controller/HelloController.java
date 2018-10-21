package com.gehui.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/19 11:13.
 **/
@RestController
public class HelloController {
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        System.out.println("HelloWorld 欢迎你 ：" + name);
        return "欢迎来到Hello项目"+name;
    }
}
