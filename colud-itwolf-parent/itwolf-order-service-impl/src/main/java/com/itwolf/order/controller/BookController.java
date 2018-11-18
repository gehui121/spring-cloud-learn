package com.itwolf.order.controller;

import com.itwolf.base.BaseApiService;
import com.itwolf.base.ResponseBase;
import com.itwolf.feign.BookFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/9 14:57.
 **/
@RestController
public class BookController extends BaseApiService {

    @Autowired
    public BookFeign bookFeign;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @HystrixCommand(fallbackMethod = "getBookInfoFallback")
    @RequestMapping(value = "/getBookInfo")
    public ResponseBase getBookInfo(){
        logger.info("getBookInfo当前线程是：{}",Thread.currentThread().getName());
        ResponseBase reponse = bookFeign.getBookInfo();
        logger.info("reponse: {}",reponse);
        return reponse;
    }

    public ResponseBase getBookInfoFallback(){
        return setFailedResult("服务器忙，请稍后重试");
    }


    /**
     * Hystrix第二种写法，只有feign调用的代码使用新的线程池
     * 使用类的方式进行服务降级，
     * @return
     */
    @RequestMapping(value = "/getBookInfoHystrix")
    public ResponseBase getBookInfoHystrix(){
        logger.info("getBookInfoHystrix当前线程是：{}",Thread.currentThread().getName());
        ResponseBase reponse = bookFeign.getBookInfo();
        logger.info("reponse: {}",reponse);
        return reponse;
    }
}
