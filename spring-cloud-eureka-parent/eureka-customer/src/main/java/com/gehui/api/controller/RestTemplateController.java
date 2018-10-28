package com.gehui.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/10/23 17:12.
 **/
@RestController
public class RestTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/rest/hello/{name}")
    public String hello(@PathVariable String name){
        logger.info("请求消费者参数是：{}",name);
        StringBuffer stringBuffer = new StringBuffer();
        String url = stringBuffer.append("http://eureka-service/hello/" + name).toString();
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
