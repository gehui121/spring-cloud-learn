package com.itwolf.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/24 13:36.
 **/
@RestController
public class SwaggerController {

    @GetMapping("/getMember")
    @ApiOperation("会员服务接口")
    public String getMember(){
        return "会员服务接口";
    }

}
