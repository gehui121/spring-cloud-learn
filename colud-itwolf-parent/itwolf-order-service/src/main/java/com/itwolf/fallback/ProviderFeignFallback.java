package com.itwolf.fallback;

import com.itwolf.common.base.BaseApiService;
import com.itwolf.common.base.ResponseBase;
import com.itwolf.feign.ProviderFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/5 20:56.
 **/
@Component
public class ProviderFeignFallback extends BaseApiService implements ProviderFeign {

    public ResponseBase getPoviderData1() {
        return setResult(getPoviderData());
    }

    @Override
    public List<Object> getPoviderData() {
        List<Object> list = new ArrayList<>();
        list.add("调用会员服务失败");
        return list;
    }
}
