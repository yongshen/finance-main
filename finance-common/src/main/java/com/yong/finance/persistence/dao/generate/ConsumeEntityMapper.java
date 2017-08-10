package com.yong.finance.persistence.dao.generate;

import com.yong.finance.common.support.bean.ConsumeSearchBean;
import com.yong.finance.persistence.base.BaseMapper;
import com.yong.finance.persistence.entity.ConsumeEntity;
import com.yong.finance.persistence.result.ConsumeResult;

import java.util.List;

public interface ConsumeEntityMapper extends BaseMapper<ConsumeEntity> {

    //获取财务列表
    List<ConsumeResult> getListByParams(ConsumeSearchBean searchBean);
}