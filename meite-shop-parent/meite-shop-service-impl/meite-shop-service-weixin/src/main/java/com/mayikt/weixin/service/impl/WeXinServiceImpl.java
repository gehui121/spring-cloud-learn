package com.mayikt.weixin.service.impl;

import com.mayikt.weixin.entity.APPEntity;
import com.mayikt.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

/**
*@Description 微信服务提供服务没有视图层所以不写controller而是service
 * 实现中不用写url映射
*@Date 15:34 2019/1/19
*@Param
*@Return 
**/
@RestController
public class WeXinServiceImpl implements WeiXinService {

    @Override
    public APPEntity getApp() {
        return new APPEntity("001","gehui");
    }
}
