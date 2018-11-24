package com.itwolf.order.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/24 10:46.
 **/
@RestController
public class SwaggerController {

    @ApiOperation("获取用户相关信息")
    @PostMapping("/getOrder")
    public String getOrder(String userName) {
        System.out.println("userName: " + userName);
        return "userName: " + userName;
    }
}
