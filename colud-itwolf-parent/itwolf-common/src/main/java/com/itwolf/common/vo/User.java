package com.itwolf.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/15 15:53.
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -4083327605430665846L;

    public final static String CONTEXT_KEY_USERID = "x-customs-user";

    private String userId;
    private String userName;

    public User(Map<String, String> headers) {
        userId = headers.get(CONTEXT_KEY_USERID);
    }

    /**
     * 将user对象转换成为http对象头
     * @return http头键值对
     */
    public Map<String, String> toHttpHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTEXT_KEY_USERID,userId);
        return headers;
    }


    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
