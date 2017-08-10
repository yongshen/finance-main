package com.yong.finance.cms.support.common;


import com.yong.finance.persistence.base.BaseEntity;
import com.yong.finance.persistence.base.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
public abstract class BaseService {

    protected Logger _logger = LoggerFactory.getLogger(BaseService.class);

    protected <T extends BaseMapper, F extends BaseEntity> void saveOrUpdate(T repository, F entity) throws Exception {
        Integer id = (Integer) entity.getClass().getMethod("getId").invoke(entity);
        if(null == id){
            repository.insert(repository);
        }else{
            repository.updateByPrimaryKey(repository);
        }
    }

}
