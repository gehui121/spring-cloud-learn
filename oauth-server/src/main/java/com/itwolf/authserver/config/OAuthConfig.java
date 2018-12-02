package com.itwolf.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Created by Administrator on 2018/11/27 22:39.
 * 使用内存方式直接注册了一个ClientID为springclouddemo，客户端的secret为scdsecret，并且
 * 授权该客户端可以使用refresh_token，password、client_credentials等的客户端授权方式
 **/
@Configuration
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //通过内存方式设置认证的客户端
        clients.inMemory()
                .withClient("springclouddemo")
                .secret("scdsecret")
                .authorizedGrantTypes("refresh_token","password","client_credentials")
                .scopes("webclient","mobileclient");
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //设置用户认证的时
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
