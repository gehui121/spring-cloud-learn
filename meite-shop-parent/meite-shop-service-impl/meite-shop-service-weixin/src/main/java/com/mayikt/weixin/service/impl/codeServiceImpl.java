package com.mayikt.weixin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.constant.Constants;
import com.mayikt.core.utils.RedisUtils;
import com.mayikt.weixin.service.codeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName codeServiceImpl
 * @Description
 * @Author gehui
 * @Date 2019/1/28 22:59
 * @Version 1.0
 **/
@RestController
public class codeServiceImpl extends BaseApiService<JSONObject> implements codeService {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * @Description 根据手机号验证微信注册码是否正确实现
     * @Date 23:02 2019/1/28
     * @Param [phone, code]
     * @Return com.mayikt.base.BaseResponse<com.alibaba.fastjson.JSONObject>
     **/
    @Override
    public BaseResponse<JSONObject> validateWeiXinCode(String phone, String code) {
        //1.判断入参是否为空，参数验证
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)) {
            setResultError("手机号码或者验证码不能为空");
        }
        //2.根据手机号码获取redis中存储的code
        String weiXinCode = Constants.WEIXINCODE_KEY + phone;
        Object object = redisUtils.get(weiXinCode);
        //3.判断redis中的code与入参中的code是否相等
        if (object == null) {
            return setResultError("验证码可能已经实现，请重新申请");
        }
        if (!code.equals(object.toString())) {
            return setResultError("您输入的验证码有误，请重新输入");
        }
        //4.验证成功，移除redis中的验证码
        redisUtils.del(weiXinCode);
        return setResultSuccess("验证码验证成功");
    }
}
