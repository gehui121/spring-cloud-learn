package com.gehui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/10/20 9:37.
 **/
@RestController
@RequestMapping(value = "/customer")
public class HelloCustomerController {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(HelloCustomerController.class);

    //注入restTemplate模板
    @Autowired
    private RestTemplate restTemplate;
    //注入客户端对象
    @Autowired
    private DiscoveryClient discoveryClient;

    //动态获取服务提供者的服务实例
    private String instanceId;

    @RequestMapping(value = "/init")
    public void init() {
        discoveryClient.getInstances("hello-service")
                .stream()
                .forEach(
                        instance -> {
                            instanceId = instance.getServiceId();
                            logger.info("服务地址：{}，服务端口号：{}，服务实例编号：{}，服务地址：{}", instance.getHost(), instance.getPort(), instance.getServiceId(), instance.getUri());
                        }
                );
    }


    /**
     * 在restTemplate发送的请求中将服务名称写死，访问hello-service提供者
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        logger.info("通过写死服务名称调用提供者开始");
        String response = restTemplate.getForObject("http://hello-service/hello/" + name, String.class);
        logger.info("消费者hello-customer使用restTemplate模板通过服务名远程调用EurekaServer中注册的hello-service服务：" + response);
        logger.info("服务名称写死，访问hello-service提供者：{}", response);
        return response;
    }

    /**
     * 通过动态获取到的instanceID调用提供者
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello2/{name}")
    public String hello2(@PathVariable String name) {
        logger.info("开始通过动态获取到的服务实例调用hello-servie服务");
        //String response = restTemplate.getForEntity("http://" + instance.getServiceId() + "/hello"+name, String.class).getBody();
        String response = restTemplate.getForObject("http://" + instanceId + "/hello/" + name, String.class);
        logger.info("通过动态获取提供者服务实例获调用服务响应的内容：{}", response);
        return response;
    }

}
