package com.itwolf.order.controller;

import com.itwolf.common.base.BaseApiService;
import com.itwolf.common.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/18 17:53.
 **/
@RefreshScope
@RestController
public class ConfigClient extends BaseApiService {

    @Value("${age}")
    private String itwolf;

    @GetMapping(value = "/getItwolf")
    public ResponseBase getItwolf(){
        return setResult(itwolf);
    }
}
