package com.yong.finance.persistence.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by sgy on 2017/7/30
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
