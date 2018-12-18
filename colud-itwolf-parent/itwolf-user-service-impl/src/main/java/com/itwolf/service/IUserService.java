package com.itwolf.service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/15 14:29.
 **/
public interface IUserService {
    String getDefaultUser();

    String getContextUserId();

    List<String> getProviderData();

}
