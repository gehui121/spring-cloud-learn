package com.itwolf.order.controller;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.base.ResponseBase;
import com.itwolf.feign.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/10/30 17:12.
 **/
@RestController
public class UserController {

    @Autowired
    private UserFeign userFeign;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 验证服务雪崩，没用Hystrix，服务没延迟秒
     * @param name
     * @return
     */
    @PostMapping(value = "/getUserInfo/{name},{age}")
    public UserEntity getUserInfo(@PathVariable String name, @PathVariable Integer age){
        logger.info("验证服务雪崩，没用Hystrix，服务没延迟，当前线程是：{}",Thread.currentThread().getName());
        UserEntity response = userFeign.getUserInfo(name, age);
        return response;
    }

    /**
     * 验证服务雪崩，没用Hystrix，没有解决服务雪崩效应，服务延迟2秒
     * @return
     */
    @GetMapping(value = "/orderToUserInfo")
    public String orderToUserInfo(){
        logger.info("没用Hystrix，服务延迟2秒，orderToUserInfo当前线程是：{}",Thread.currentThread().getName());
        String response = userFeign.orderToUserInfo();
        return response;
    }

    /*
    使用Hystrix解决服务雪崩效应,调用的都是生产者延迟2秒的服务
     */
    @HystrixCommand(fallbackMethod = "orderToUserInfoFallback")
    @GetMapping(value = "/orderToUserInfoHystrix")
    public String orderToUserInfoHystrix(){
        logger.info("使用Hystrix解决服务雪崩 orderToUserInfoHystrix当前线程是：{}",Thread.currentThread().getName());
        String response = userFeign.orderToUserInfo();
        return response;
    }

    /**
     * 服务降级执行方法
     * @return
     */
    public String orderToUserInfoFallback(){
        return "返回友好的提示：服务器忙，请重试";
    }

    @GetMapping(value = "/orderInfo")
    public String orderInfo(){
        logger.info("orderInfo当前线程是：{}",Thread.currentThread().getName());
        return "调用成功";
    }

    //测试服务接口统一响应
    @GetMapping(value = "/testResponse")
    public ResponseBase testResponse(){
        ResponseBase responseBase = userFeign.testResponse();
        return responseBase;
    }
}
