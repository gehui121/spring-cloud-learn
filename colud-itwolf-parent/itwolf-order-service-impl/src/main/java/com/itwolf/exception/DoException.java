package com.itwolf.exception;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/8 11:12.
 **/
@RestController
public class DoException {

    @GetMapping(value = "/notCatcheException")
    @HystrixCommand(fallbackMethod = "exceptionFallback")
    public String notCatcheException() {
        throw new HystrixBadRequestException("这个异常是由非法参数或者非系统异常引起的，hystrix不会降级的");
    }

    @GetMapping(value = "/catcheException")
    @HystrixCommand(fallbackMethod = "exceptionFallback")
    public String catcheException() {
        throw new RuntimeException("getFallbackMethod failed");
    }

    public String exceptionFallback(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return "This is fallback message :" + throwable.getMessage();
    }
}
