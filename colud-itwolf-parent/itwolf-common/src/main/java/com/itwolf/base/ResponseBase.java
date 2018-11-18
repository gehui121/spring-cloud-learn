package com.itwolf.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by Administrator on 2018/11/8 17:23.
 * 服务接口统一规范响应
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBase {
    private Object header;
    private Object body;
}
