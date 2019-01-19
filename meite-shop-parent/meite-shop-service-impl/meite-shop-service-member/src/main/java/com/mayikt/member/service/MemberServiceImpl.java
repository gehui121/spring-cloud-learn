package com.mayikt.member.service;

import com.mayikt.member.feign.WeiXinServiceFeign;
import com.mayikt.weixin.entity.APPEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public APPEntity memberToWeiXin() {
        APPEntity appEntity = weiXinServiceFeign.getApp();
        return appEntity;
    }
}
