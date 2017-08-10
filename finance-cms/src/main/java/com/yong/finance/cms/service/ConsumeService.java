package com.yong.finance.cms.service;

import com.github.pagehelper.Page;
import com.yong.finance.common.bean.PageBean;
import com.yong.finance.common.exception.AppRuntimeException;
import com.yong.finance.common.support.bean.ConsumeSearchBean;
import com.yong.finance.persistence.entity.ConsumeEntity;

import java.util.List;

/**
 * Created by sgy on 2017/08/07.
 */
public interface ConsumeService {

    //根据搜索条件获取列表
    Page getConsumeList(ConsumeSearchBean searchBean, PageBean pageBean) throws AppRuntimeException;
}
