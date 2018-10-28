package com.itwolf.api.feign.impl;

import com.itwolf.api.feign.RefactorHelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/27 8:58.
 **/
@RestController
public class RefactorHelloController implements RefactorHelloService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String hell0() {
        return "调用 " + serverPort + " 端口服务器成功";
    }
}
