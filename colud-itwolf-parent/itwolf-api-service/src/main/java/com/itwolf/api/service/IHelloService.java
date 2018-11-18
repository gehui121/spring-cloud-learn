package com.itwolf.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/29 17:38.
 **/
public interface IHelloService {
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable(value = "name") String name);
}
