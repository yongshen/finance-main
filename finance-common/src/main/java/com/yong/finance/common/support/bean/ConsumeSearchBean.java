package com.yong.finance.common.support.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sgy on 2017/08/07.
 */
public class ConsumeSearchBean implements Serializable {

    private String searchName;
    private Integer consumeType;
    private Integer financeType;
    private Date startDate;
    private Date endDate;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Integer financeType) {
        this.financeType = financeType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
