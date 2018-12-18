package com.itwolf.common.base;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/8 17:22.
 **/
@Component
public class BaseApiService {

    //调用接口成功，没有msg
    public ResponseBase setResult(Object body){
        Map<String,String> header = new HashMap<>();
        header.put("code","200");
        header.put("msg",null);
        return new ResponseBase(header,body);
    }

    //调用接口成功，没有返回值
    public ResponseBase setResult(String msg){
        Map<String,String> header = new HashMap<>();
        header.put("code","200");
        header.put("msg",msg);
        return new ResponseBase(header,null);
    }
    //调用接口成功，没有返回值
    public ResponseBase setResult(){
        Map<String,String> header = new HashMap<>();
        header.put("code","200");
        header.put("msg","接口调用成功");
        return new ResponseBase(header,null);
    }

    //调用接口失败，没有body
    public ResponseBase setFailedResult(String code, String msg){
        Map<String,String> header = new HashMap<>();
        header.put("code",code);
        header.put("msg",msg);
        return new ResponseBase(header,null);
    }

    //调用接口失败,固定的code
    public ResponseBase setFailedResult(String msg){
        Map<String,String> header = new HashMap<>();
        header.put("code","500");
        header.put("msg",msg);
        return new ResponseBase(header,null);
    }



}
