package com.mayikt.weixin.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName APPEntity
 * @Description 微信实体类
 * @Author Administrator
 * @Date 2019/1/19 14:35
 * @Version 1.0
 **/
@Data
@ToString
public class APPEntity {
    /**
    *AppId
    **/
    private String AppId;
    /**
    *AppName
    **/
    private String AppName;

    public APPEntity() {
    }

    public APPEntity(String appId, String appName) {
        AppId = appId;
        AppName = appName;
    }
}
