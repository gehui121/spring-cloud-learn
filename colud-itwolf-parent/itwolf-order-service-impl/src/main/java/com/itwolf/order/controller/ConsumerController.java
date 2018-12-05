package com.itwolf.order.controller;

import com.itwolf.base.BaseApiService;
import com.itwolf.base.ResponseBase;
import com.itwolf.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/12/3 22:23.
 **/

@RestController
public class ConsumerController extends BaseApiService {

    @Autowired
    private ProviderFeign providerFeign;

    @RequestMapping("/getDashboard")
    public ResponseBase getDashboard(){
        List<Object> poviderData = providerFeign.getPoviderData();
        ResponseBase responseBase = setResult(poviderData);
        return responseBase;
    }
}
