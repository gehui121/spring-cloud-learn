package com.itwolf.api.controller;

import com.itwolf.api.service.IGetDashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/12/3 22:09.
 **/
@RestController
public class ProviderController implements IGetDashboardService {
    private static Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @RequestMapping("/getDashboard")
    @Override
    public List<Object> getPoviderData() {

        Random r = new Random();
        int time = r.nextInt(3000);
        logger.info("阻塞时间是：。。。。。。。。。。。。。"+time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        String s4 = "d";
        String s5 = "e";
        List<Object> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(time);
        return list;
    }
}
