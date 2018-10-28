package com.gehui.api.controller;

import com.gehui.feign.HelloApiFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/23 19:24.
 **/
@RestController
public class FeignController {
    private static final Logger logger = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private HelloApiFeign helloApiFeign;

    @RequestMapping(value = "/feign/hello/{name}")
    public String feignHello(@PathVariable String name){
        logger.info("使用Feign客户端调用远程服务开始，参数是：{}",name);
        String response = helloApiFeign.hello(name);
        logger.info("使用Feign客户端调用远程服务结束，响应报文是：{}",response);
        return response;
    }
}
