package com.itwolf.controller;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.api.service.IUserService;
import com.itwolf.base.BaseApiService;
import com.itwolf.base.ResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/30 17:06.
 **/
@RestController
public class UserController extends BaseApiService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${server.port}")
    private String serverPort;

    /**
     * 验证服务雪崩，没用Hystrix，服务没延迟秒
     * @param name
     * @return
     */
    @RequestMapping(value = "/getUserInfo/{name},{age}")
    @Override
    public UserEntity getUserInfo(@PathVariable String name, @PathVariable Integer age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setServerPort(serverPort);
        logger.info("orderToUserInfo 没延迟，当前线程：{}",Thread.currentThread().getName());
        return userEntity;
    }

    /**
     * 验证服务雪崩，没用Hystrix，服务延迟2秒
     * @return
     */
    @RequestMapping(value = "/orderToUserInfo")
    @Override
    public String orderToUserInfo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("orderToUserInfo 延迟2秒，当前线程：{}",Thread.currentThread().getName());
        return "调用会员服务成功"+serverPort;
    }

    //测试服务接口统一响应
    @RequestMapping(value = "/testResponse")
    @Override
    public ResponseBase testResponse() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("安其拉");
        userEntity.setAge(12);
        userEntity.setServerPort(serverPort);
        return setResult(userEntity);
    }
}
