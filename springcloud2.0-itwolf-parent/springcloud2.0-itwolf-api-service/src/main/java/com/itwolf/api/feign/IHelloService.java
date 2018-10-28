package com.itwolf.api.feign;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/27 8:55.
 **/
public interface IHelloService {
    @RequestMapping(value = "/hello")
    public String hell0();
}
