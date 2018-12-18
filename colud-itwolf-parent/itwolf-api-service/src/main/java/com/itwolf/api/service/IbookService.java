package com.itwolf.api.service;

import com.itwolf.common.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/11/9 14:59.
 **/
public interface IbookService {
    @RequestMapping(value = "/getBookInfo")
    public ResponseBase getBookInfo();
}
