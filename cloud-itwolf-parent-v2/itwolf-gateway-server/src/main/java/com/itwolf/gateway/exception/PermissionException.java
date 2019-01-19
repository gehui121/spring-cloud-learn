package com.itwolf.gateway.exception;

/**
 * Created by Administrator on 2018/12/23 10:01.
 **/
public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PermissionException(String msg) {
        super(msg);
    }
}