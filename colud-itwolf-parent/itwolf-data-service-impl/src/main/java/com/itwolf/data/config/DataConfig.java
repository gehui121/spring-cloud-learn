package com.itwolf.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/15 15:38.
 *  配置信息
 **/
@RefreshScope
@Component
public class DataConfig {

        @Value("${defaultUser}")
    private String defaultUser;

    public String getDefaultUser() {
        return defaultUser;
    }
}
