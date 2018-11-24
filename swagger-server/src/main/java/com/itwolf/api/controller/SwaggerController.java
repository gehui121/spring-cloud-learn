package com.itwolf.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/24 9:36.
 * @RequestMapping 不推荐使用
 * 如果是get请求  @GetMapping
 * 如果是post请求 @PostMapping
 **/
@Api("swaggerDemo控制器")
@RestController
public class SwaggerController {

    @ApiOperation("swagger演示服务接口")
    @RequestMapping("/swaggerIndex")
    public String swaggerIndex(){
        System.out.print("欢迎访问swagger");
        return "欢迎访问swagger";
    }
}
