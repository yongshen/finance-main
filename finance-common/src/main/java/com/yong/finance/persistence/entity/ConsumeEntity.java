package com.yong.finance.persistence.entity;

import com.yong.finance.persistence.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "z_consume")
public class ConsumeEntity extends BaseEntity implements Serializable {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 财务类型（1收入  2支出）
     */
    @Column(name = "finance_type")
    private Integer financeType;

    /**
     * 消费类型
     */
    @Column(name = "consume_type")
    private Integer consumeType;

    /**
     * 消费详细信息
     */
    @Column(name = "consume_detail")
    private String consumeDetail;

    /**
     * 消费金额
     */
    @Column(name = "consume_money")
    private Double consumeMoney;

    /**
     * 消费日期
     */
    @Column(name = "consume_date")
    private Date consumeDate;

    /**
     * 消费地点
     */
    @Column(name = "consume_location")
    private String consumeLocation;

    /**
     * 记录日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态（1有效 2删除）
     */
    private Integer state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取财务类型（1收入  2支出）
     *
     * @return finance_type - 财务类型（1收入  2支出）
     */
    public Integer getFinanceType() {
        return financeType;
    }

    /**
     * 设置财务类型（1收入  2支出）
     *
     * @param financeType 财务类型（1收入  2支出）
     */
    public void setFinanceType(Integer financeType) {
        this.financeType = financeType;
    }

    /**
     * 获取消费类型
     *
     * @return consume_type - 消费类型
     */
    public Integer getConsumeType() {
        return consumeType;
    }

    /**
     * 设置消费类型
     *
     * @param consumeType 消费类型
     */
    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public String getConsumeDetail() {
        return consumeDetail;
    }

    public void setConsumeDetail(String consumeDetail) {
        this.consumeDetail = consumeDetail;
    }

    /**
     * 获取消费金额
     *
     * @return consume_money - 消费金额
     */
    public Double getConsumeMoney() {
        return consumeMoney;
    }

    /**
     * 设置消费金额
     *
     * @param consumeMoney 消费金额
     */
    public void setConsumeMoney(Double consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    /**
     * 获取消费日期
     *
     * @return consume_date - 消费日期
     */
    public Date getConsumeDate() {
        return consumeDate;
    }

    /**
     * 设置消费日期
     *
     * @param consumeDate 消费日期
     */
    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    /**
     * 获取消费地点
     *
     * @return consume_location - 消费地点
     */
    public String getConsumeLocation() {
        return consumeLocation;
    }

    /**
     * 设置消费地点
     *
     * @param consumeLocation 消费地点
     */
    public void setConsumeLocation(String consumeLocation) {
        this.consumeLocation = consumeLocation == null ? null : consumeLocation.trim();
    }

    /**
     * 获取记录日期
     *
     * @return create_time - 记录日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录日期
     *
     * @param createTime 记录日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改日期
     *
     * @return update_time - 修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改日期
     *
     * @param updateTime 修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态（1有效 2删除）
     *
     * @return state - 状态（1有效 2删除）
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态（1有效 2删除）
     *
     * @param state 状态（1有效 2删除）
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}