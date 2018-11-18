package com.itwolf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/14 22:00.
 **/

@RefreshScope
@RestController
public class TestConfigClient {

//    @Value("${itwolfInfo}")
//    private String itwolfInfo;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/itwolfInfo")
    public String itwolfInfo(){
//        return this.itwolfInfo;
        String itwolfInfo = environment.getProperty("itwolfInfo","undefined");
        return itwolfInfo;
    }

}
