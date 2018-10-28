package com.itwolf.api.feign.impl;

import com.itwolf.api.feign.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/27 9:18.
 **/
@RestController
public class RefactorHelloContrroller implements RefactorHelloService {

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/refactor/hello")
    @Override
    public String hell0() {
        String response = refactorHelloService.hell0();
        return response;
    }
}
