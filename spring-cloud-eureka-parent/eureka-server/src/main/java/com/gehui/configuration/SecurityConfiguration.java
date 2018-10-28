package com.gehui.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2018/10/20 8:46.
 * 开启Eureka Server安全认证配置
 **/
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        安全配置信息
            禁用csrf攻击功能
            开启所有请求需要验证并且是http Basic认证
         */
        http.csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

}
