package com.itwolf.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/12/3 22:06.
 **/
public interface IGetDashboardService {
    @RequestMapping("/getDashboard")
    public List<Object> getPoviderData();
}
