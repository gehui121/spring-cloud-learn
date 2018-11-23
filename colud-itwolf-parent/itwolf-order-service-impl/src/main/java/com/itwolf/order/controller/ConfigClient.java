package com.itwolf.order.controller;

import com.itwolf.base.BaseApiService;
import com.itwolf.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/18 17:53.
 **/
@RefreshScope
@RestController
public class ConfigClient extends BaseApiService {

    @Value("${itwolf}")
    private String itwolf;

    @RequestMapping(value = "/getItwolf")
    public ResponseBase getItwolf(){
        return setResult(itwolf);
    }
}
