package com.itwolf.fallback;

import com.itwolf.base.BaseApiService;
import com.itwolf.base.ResponseBase;
import com.itwolf.feign.BookFeign;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/11/12 21:18.
 **/
@Component
public class BookFallback extends BaseApiService implements BookFeign {

    @Override
    //服务降级的友好提示
    public ResponseBase getBookInfo() {
        return setFailedResult("使用类的方式进行服务降级友好提示");
    }
}
