package com.gehui.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 17:40.
 **/
@RestController
public class ExtRibbonController {

    private static final Logger logger = LoggerFactory.getLogger(ExtRibbonController.class);

    //可以获取服务注册中心的服务列表
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    private int reqCount = 1;

    //纯手写Ribbon本地负载均衡
    @RequestMapping(value = "/ribbonHello/{name}")
    public String ribbonHello(@PathVariable String name) throws Exception {
        //获取远程服务器远程地址
        String instanceUrl = getInstances() + "/hello/" + name;
        logger.info("调用远程服务地址是：{}",instanceUrl);
        String respose = restTemplate.getForObject(instanceUrl, String.class);
        logger.info("调用远程服务返回的内容是：{}",respose);
        return respose;
    }

    //通过discoveryClient获取注册中心服务列表
    public String getInstances() throws Exception {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-service");
        if (instances == null || instances.size() <= 0){
            logger.info("目前没有远程服务器");
            throw new Exception("目前没有远程服务器");
        }
        int size = instances.size();
        logger.info("远程服务器有"+size+"台");
        int instanceIndex = reqCount % size;
        reqCount ++;
        String instanceUri = instances.get(instanceIndex).getUri().toString();
        logger.info("请求远程服务的uri是：{}",instanceUri);
        return instanceUri;
    }
}
