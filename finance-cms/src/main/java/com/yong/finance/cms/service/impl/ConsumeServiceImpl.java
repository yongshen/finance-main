package com.yong.finance.cms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yong.finance.cms.service.ConsumeService;
import com.yong.finance.cms.support.common.BaseService;
import com.yong.finance.common.bean.PageBean;
import com.yong.finance.common.exception.AppRuntimeException;
import com.yong.finance.common.support.bean.ConsumeSearchBean;
import com.yong.finance.persistence.dao.generate.ConsumeEntityMapper;
import com.yong.finance.persistence.entity.ConsumeEntity;
import com.yong.finance.persistence.result.ConsumeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sgy on 2017/08/07.
 */
@Transactional
@Service("consumeService")
public class ConsumeServiceImpl extends BaseService implements ConsumeService {

    @Autowired
    private ConsumeEntityMapper consumeMapper;

    @Override
    public Page getConsumeList(ConsumeSearchBean searchBean, PageBean pageBean) throws AppRuntimeException {
        PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        Page page = (Page<ConsumeResult>)consumeMapper.getListByParams(searchBean);
        return page;
    }
}
