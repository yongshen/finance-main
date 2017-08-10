package com.yong.finance.persistence.entity;

import com.yong.finance.persistence.base.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "z_consume_type")
public class ConsumeTypeEntity extends BaseEntity implements Serializable {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 类型代码
     */
    @Column(name = "type_code")
    private String typeCode;

    /**
     * 类型名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 状态
     */
    @Column(name = "type_state")
    private Integer typeState;

    /**
     * 财务类型（1收入  2支出）
     */
    @Column(name = "finance_type")
    private Integer financeType;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型代码
     *
     * @return type_code - 类型代码
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置类型代码
     *
     * @param typeCode 类型代码
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * 获取类型名称
     *
     * @return type_name - 类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类型名称
     *
     * @param typeName 类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取状态
     *
     * @return type_state - 状态
     */
    public Integer getTypeState() {
        return typeState;
    }

    /**
     * 设置状态
     *
     * @param typeState 状态
     */
    public void setTypeState(Integer typeState) {
        this.typeState = typeState;
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
}