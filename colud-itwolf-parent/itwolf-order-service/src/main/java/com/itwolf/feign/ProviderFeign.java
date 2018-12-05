package com.itwolf.feign;

import com.itwolf.api.service.IGetDashboardService;
import com.itwolf.fallback.ProviderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/12/3 22:20.
 **/
@FeignClient(value = "member-service",fallback=ProviderFeignFallback.class)
public interface ProviderFeign extends IGetDashboardService {
}
