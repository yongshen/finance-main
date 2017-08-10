package com.yong.finance.cms.service.impl;

import com.yong.finance.cms.service.UserService;
import com.yong.finance.cms.support.common.BaseService;
import com.yong.finance.common.exception.AppRuntimeException;
import com.yong.finance.persistence.dao.generate.UserEntityMapper;
import com.yong.finance.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by weitong on 17/3/24.
 */
@Transactional
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserEntityMapper userMapper;

    @Override
    public List<UserEntity> getUserBySingleParam(String param, String paramValue) throws AppRuntimeException {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo(param, paramValue);
        List<UserEntity> list = userMapper.selectByExample(example);
        return list;
    }

    @Override
    public int createNewUser(UserEntity entity) throws AppRuntimeException {
        return userMapper.insertUseGeneratedKeys(entity);
    }
}
