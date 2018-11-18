package com.itwolf.api.feign.impl;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.api.feign.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/27 9:40.
 **/
@RestController
public class RefactorUserController implements IUserService {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/user/{name}")
    @Override
    public UserEntity getUser(@PathVariable String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setServerPort(serverPort);
        userEntity.setAge(12);
        userEntity.setName(name);
        return userEntity;
    }

    @RequestMapping(value = "/getUserByNameAndAge/{name},{age}")
    @Override
    public UserEntity getUserByNameAndAge(@PathVariable String name, @PathVariable Integer age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setServerPort(serverPort);
        return userEntity;
    }

    /**
     * 没有使用Hystrix，验证服务雪崩效应，服务可以快速反应没有延迟
     * @return
     */
    @RequestMapping(value = "/getUserInfo")
    @Override
    public String getUserInfo() {
        return "消费者调用生产者成功，快速响应验证服务雪崩"+serverPort;
    }

    /**
     * 没有使用Hystrix，验证服务雪崩效应，服务延迟2秒
     * @return
     */
    @RequestMapping(value = "/customerToUserInfo")
    @Override
    public String customerToUserInfo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "消费者调用生产者成功，延迟2秒后验证服务雪崩"+serverPort;
    }
}
