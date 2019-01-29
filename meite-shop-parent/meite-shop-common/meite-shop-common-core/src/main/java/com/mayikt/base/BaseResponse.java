package com.mayikt.base;

import lombok.Data;

/**
 * @ClassName BaseResponse
 * @Description
 * @Author gehui
 * @Date 2019/1/28 21:44
 * @Version 1.0
 **/
@Data
public class BaseResponse<T> {

    /**
     * 状态码
    **/
    private Integer code;
    /**
     * 消息
     **/
    private String msg;
    /**
     *业务数据
    **/
    private T data;

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
