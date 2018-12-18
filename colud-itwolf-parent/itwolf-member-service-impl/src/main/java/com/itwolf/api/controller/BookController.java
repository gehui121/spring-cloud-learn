package com.itwolf.api.controller;

import com.itwolf.api.entity.BookEntity;
import com.itwolf.api.service.IbookService;
import com.itwolf.common.base.BaseApiService;
import com.itwolf.common.base.ResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2018/11/9 15:16.
 **/
@RestController
public class BookController extends BaseApiService implements IbookService {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/getBookInfo")
    public ResponseBase getBookInfo(){
        Random r = new Random();
        int time = r.nextInt(3000);
        logger.info("阻塞"+time+"毫秒");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("java成神之路");
        bookEntity.setBookPrice(12.4);
        Map<String,Object> response = new HashMap<>();
        response.put("bookEntity",bookEntity);
        response.put("serverPort",serverPort);
        response.put("timeOut",time);
        return setResult(response);
    }
}
