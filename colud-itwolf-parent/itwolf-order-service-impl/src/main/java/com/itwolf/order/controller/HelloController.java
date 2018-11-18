package com.itwolf.order.controller;

import com.itwolf.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/29 17:46.
 **/
@RestController
public class HelloController{

    @Autowired
    private HelloFeign helloFeign;


    @RequestMapping(value = "/sayHello/{name}")
    public String sayHello(@PathVariable String name) {
        String response = helloFeign.hello(name);
        return response;
    }
}
