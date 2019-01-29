package com.mayikt.weixin.service.impl;

import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.weixin.entity.APPEntity;
import com.mayikt.weixin.service.WeiXinService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
*@Description 微信服务提供服务没有视图层所以不写controller而是service
 * 实现中不用写url映射
 * 使用泛型，一个接口中只能返回一种类型的实体
*@Date 15:34 2019/1/19
*@Param
*@Return 
**/
@RestController
public class WeXinServiceImpl extends BaseApiService<APPEntity> implements WeiXinService {

    @Value("${mayikt.weixin.appId}")
    private String appId;

    @Override
    public BaseResponse<APPEntity> getApp() {
        return setResultSuccess("访问成功",new APPEntity("121","gehui"));
    }
}
