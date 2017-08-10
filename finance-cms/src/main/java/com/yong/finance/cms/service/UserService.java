package com.yong.finance.cms.service;

import com.yong.finance.common.exception.AppRuntimeException;
import com.yong.finance.persistence.entity.UserEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public interface UserService {

    //根据账号获取用户
    List<UserEntity> getUserBySingleParam(String param, String paramValue) throws AppRuntimeException;

    //创建用户
    int createNewUser(UserEntity entity) throws AppRuntimeException;

}
