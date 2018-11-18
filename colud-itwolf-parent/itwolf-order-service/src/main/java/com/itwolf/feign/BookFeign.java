package com.itwolf.feign;

import com.itwolf.api.service.IbookService;
import com.itwolf.fallback.BookFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/11/9 15:29.
 **/
@FeignClient(value = "member-service",fallback = BookFallback.class)
public interface BookFeign extends IbookService {
}
