package com.itwolf.api.feign.impl;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.api.feign.RefactorUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/27 9:48.
 **/
@RestController
public class RefactorUserController implements RefactorUserService {
    private static final Logger logger = LoggerFactory.getLogger(RefactorUserController.class);

    @Autowired
    private RefactorUserService refactorUserService;


    @RequestMapping(value = "/getuser/{name}")
    @Override
    public UserEntity getUser(@PathVariable String name) {
        UserEntity response = refactorUserService.getUser(name);
        return response;
    }

    @RequestMapping(value = "/getUserByNameAndAge/{name},{age}")
    @Override
    public UserEntity getUserByNameAndAge(@PathVariable String name, @PathVariable Integer age) {
        UserEntity response = refactorUserService.getUserByNameAndAge(name, age);
        return response;
    }

    /**
     *  没有使用Hystrix，验证服务雪崩效应，服务快速反应，没有延迟
     * @return
     */
    @RequestMapping(value = "/getUserInfo")
    @Override
    public String getUserInfo() {
        String response = refactorUserService.getUserInfo();
        String threadName = Thread.currentThread().getName();
        logger.info("验证服务雪崩，服务不延迟，线程名称是：.......{}",threadName);
        return response;
    }

    /**
     *  没有使用Hystrix，验证服务雪崩效应，服务延迟2秒
     * @return
     */
    @RequestMapping(value = "/customerToUserInfo")
    @Override
    public String customerToUserInfo() {
        String threadName = Thread.currentThread().getName();
        String response = refactorUserService.customerToUserInfo();
        logger.info("验证服务雪崩，服务延迟2秒，线程名称是：.......{}",threadName);
        return response;
    }
}
