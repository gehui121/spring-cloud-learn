package com.gehui;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/24 12:54.
 **/
@FeignClient(value = "eureka-service")
public interface HelloApiFeign {

    // 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful的调用了
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable(value = "name") String name);

    @RequestMapping(value = "/hello1")
    public String hello1();
}
