package com.itwolf.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/21 15:16.
 **/
@RestController
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/")
    public String index() {
        return "我是会员系统，端口号是：" + serverPort;
    }
}