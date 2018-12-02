package com.itwolf.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/22 9:51.
 **/
@RefreshScope
@RestController
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${userAge}")
    private String userAge;

    @RequestMapping(value = "/")
    public String index(){
//        return "我是支付系统，端口号是："+ serverPort;
        return "我是支付系统，读取到的配置文件信息是：userAge="+userAge;
    }
}
