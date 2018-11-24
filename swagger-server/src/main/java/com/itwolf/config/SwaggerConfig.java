package com.itwolf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/11/24 9:09.
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //生成api扫包范围
                .apis(RequestHandlerSelectors.basePackage("com.itwolf.api"))
                .paths(PathSelectors.any()).build();
    }

    //创建文档信息
    private ApiInfo apiInfo(){
        //TODO 这些标题等不能写死，都从配置文件中获取，
        //title文档标题
        //description 文档描述
        //termsOfServiceUrl 自己的官方网址
        return new ApiInfoBuilder().title("野狼营训练营|服务电商系统").description("野狼课堂，java分布式微服务")
                .termsOfServiceUrl("http://www.itwolf.com")
                .version("1.0").build();
    }

}
