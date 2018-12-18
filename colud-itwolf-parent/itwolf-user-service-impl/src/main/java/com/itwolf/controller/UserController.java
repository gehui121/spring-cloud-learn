package com.itwolf.controller;

import com.itwolf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/12/15 14:28.
 **/
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 获取配置文件中系统默认用户
     * @return
     */
    @GetMapping(value ="/getDefaultUser")
    public String getDefaultUser(){
        return userService.getDefaultUser();
    }

    /**
     * 获取上下文用户
     * @return
     */
    @GetMapping(value = "/getContextUserId")
    public String getContextUserId(){
        return userService.getContextUserId();
    }

    /**
     * 获取供应商数据
     * @return
     */
    @GetMapping(value = "/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }
}
