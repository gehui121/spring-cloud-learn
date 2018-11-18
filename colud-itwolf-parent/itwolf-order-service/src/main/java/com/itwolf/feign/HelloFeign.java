package com.itwolf.feign;

import com.itwolf.api.service.IHelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/10/29 17:45.
 **/
@FeignClient("member-service")
public interface HelloFeign extends IHelloService {
}
