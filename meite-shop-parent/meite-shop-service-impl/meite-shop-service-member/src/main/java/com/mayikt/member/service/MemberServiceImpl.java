package com.mayikt.member.service;

import com.mayikt.base.BaseResponse;
import com.mayikt.member.feign.WeiXinServiceFeign;
import com.mayikt.weixin.entity.APPEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MemberToWeiXinController
 * @Description
 * @Author Administrator
 * @Date 2019/1/19 14:47
 * @Version 1.0
 **/
@RestController
public class MemberServiceImpl implements MemberService {

    @Autowired
    private WeiXinServiceFeign weiXinServiceFeign;

    @Override
    public BaseResponse<APPEntity> memberToWeiXin() {
        BaseResponse<APPEntity> response = weiXinServiceFeign.getApp();
        return response;
    }
}
