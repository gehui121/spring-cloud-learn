package com.mayikt.weixin.service;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName codeService  微信验证码验证接口
 * @Description
 * @Author gehui
 * @Date 2019/1/28 22:44
 * @Version 1.0
 **/
@Api(tags = "微信注册码验证接口")
public interface codeService {

    /**
     * @Description 微信注册码验证接口
     * @Date 22:47 2019/1/28
     * @Param [phone, code]
     * @Return com.mayikt.base.BaseResponse<com.alibaba.fastjson.JSONObject>
     **/
    @ApiOperation(value = "根据手机号验证token是否正确")
    @GetMapping(value = "/weiXinCodeService")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "用户的手机号"),
            @ApiImplicitParam(paramType = "query", name = "code", dataType = "String", required = true, value = "注册码")
    })
    public BaseResponse<JSONObject> validateWeiXinCode(String phone, String code);

}
