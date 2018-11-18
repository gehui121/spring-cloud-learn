package com.itwolf.api.entity;

import lombok.Data;

/**
 * Created by Administrator on 2018/10/28 17:29.
 **/
@Data
public class ResponseBase {
    private String resultSuccess;
    private int code;
    private String type;
    private UserEntity userEntity;
}
