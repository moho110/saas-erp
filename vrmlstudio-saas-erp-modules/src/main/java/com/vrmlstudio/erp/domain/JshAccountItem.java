package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 财务子对象 jsh_account_item
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshAccountItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 表头Id */
    @Excel(name = "表头Id")
    private Long headerId;

    /** 账户Id */
    @Excel(name = "账户Id")
    private Long accountId;

    /** 收支项目Id */
    @Excel(name = "收支项目Id")
    private Long inOutItemId;

    /** 单据id */
    @Excel(name = "单据id")
    private Long billId;

    /** 应收欠款 */
    @Excel(name = "应收欠款")
    private BigDecimal needDebt;

    /** 已收欠款 */
    @Excel(name = "已收欠款")
    private BigDecimal finishDebt;

    /** 单项金额 */
    @Excel(name = "单项金额")
    private BigDecimal eachAmount;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHeaderId(Long headerId) 
    {
        this.headerId = headerId;
    }

    public Long getHeaderId() 
    {
        return headerId;
    }
    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
    }
    public void setInOutItemId(Long inOutItemId) 
    {
        this.inOutItemId = inOutItemId;
    }

    public Long getInOutItemId() 
    {
        return inOutItemId;
    }
    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setNeedDebt(BigDecimal needDebt) 
    {
        this.needDebt = needDebt;
    }

    public BigDecimal getNeedDebt() 
    {
        return needDebt;
    }
    public void setFinishDebt(BigDecimal finishDebt) 
    {
        this.finishDebt = finishDebt;
    }

    public BigDecimal getFinishDebt() 
    {
        return finishDebt;
    }
    public void setEachAmount(BigDecimal eachAmount) 
    {
        this.eachAmount = eachAmount;
    }

    public BigDecimal getEachAmount() 
    {
        return eachAmount;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("headerId", getHeaderId())
            .append("accountId", getAccountId())
            .append("inOutItemId", getInOutItemId())
            .append("billId", getBillId())
            .append("needDebt", getNeedDebt())
            .append("finishDebt", getFinishDebt())
            .append("eachAmount", getEachAmount())
            .append("remark", getRemark())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
