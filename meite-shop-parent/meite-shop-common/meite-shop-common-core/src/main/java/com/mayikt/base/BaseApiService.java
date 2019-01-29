package com.mayikt.base;

import com.mayikt.constant.Constants;
import org.springframework.stereotype.Component;

/**
 * @ClassName BaseApiService
 * @Description
 * @Author gehui
 * @Date 2019/1/28 21:43
 * @Version 1.0
 **/
@Component
public class BaseApiService<T> {

    /**
     * @Description 错误响应
     * @Date 21:51 2019/1/28
     * @Param [code, msg]
     * @Return com.mayikt.base.BaseResponse<T>
     **/
    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * @Description 响应错误，msg
     * @Date 21:56 2019/1/28
     * @Param [msg]
     * @Return com.mayikt.base.BaseResponse<T>
     **/
    public BaseResponse<T> setResultError(String msg) {
        return setResult(Constants.HTTP_RES_CODE_500, msg, null);
    }

    /**
     * @Description 响应成功，返回数据data
     * @Date 21:58 2019/1/28
     * @Param [data]
     * @Return com.mayikt.base.BaseResponse<T>
     **/
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    /**
    *@Description 成功，没有数据返回
    *@Date 22:01 2019/1/28
    *@Param []
    *@Return com.mayikt.base.BaseResponse<T>
    **/
    public BaseResponse<T> setResultSuccess(){
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE,null);
    }

    /**
    *@Description 成功返回 没有data
    *@Date 22:03 2019/1/28
    *@Param [msg]
    *@Return com.mayikt.base.BaseResponse<T>
    **/
    public BaseResponse<T> setResultSuccess(String msg){
        return setResult(Constants.HTTP_RES_CODE_200,msg,null);
    }
    /**
    *@Description 成功返回，msg data
    *@Date 22:04 2019/1/28
    *@Param [msg]
    *@Return com.mayikt.base.BaseResponse<T>
    **/
    public BaseResponse<T> setResultSuccess(String msg,T data){
        return setResult(Constants.HTTP_RES_CODE_200,msg,data);
    }

    /**
    *@Description 成功返回，code msg data
    *@Date 22:06 2019/1/28
    *@Param [msg, data]
    *@Return com.mayikt.base.BaseResponse<T>
    **/
    public BaseResponse<T> setResultSuccess(Integer code, String msg, T data){
        return setResult(code,msg,data);
    }

    /**
     * @Description 通用封装，创建响应对象
     * @Date 21:52 2019/1/28
     * @Param [code, msg, data]
     * @Return com.mayikt.base.BaseResponse<T>
     **/
    private BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

}
