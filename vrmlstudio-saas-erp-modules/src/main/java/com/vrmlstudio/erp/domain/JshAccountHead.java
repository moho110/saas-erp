package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 财务主对象 jsh_account_head
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshAccountHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 类型(支出/收入/收款/付款/转账) */
    @Excel(name = "类型(支出/收入/收款/付款/转账)")
    private String type;

    /** 单位Id(收款/付款单位) */
    @Excel(name = "单位Id(收款/付款单位)")
    private Long organId;

    /** 经手人id */
    @Excel(name = "经手人id")
    private Long handsPersonId;

    /** 操作员 */
    @Excel(name = "操作员")
    private Long creator;

    /** 变动金额(优惠/收款/付款/实付) */
    @Excel(name = "变动金额(优惠/收款/付款/实付)")
    private BigDecimal changeAmount;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private BigDecimal discountMoney;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalPrice;

    /** 账户(收款/付款) */
    @Excel(name = "账户(收款/付款)")
    private Long accountId;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String billNo;

    /** 单据日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "单据日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date billTime;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String fileName;

    /** 状态，0未审核、1已审核 */
    @Excel(name = "状态，0未审核、1已审核")
    private String status;

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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setOrganId(Long organId) 
    {
        this.organId = organId;
    }

    public Long getOrganId() 
    {
        return organId;
    }
    public void setHandsPersonId(Long handsPersonId) 
    {
        this.handsPersonId = handsPersonId;
    }

    public Long getHandsPersonId() 
    {
        return handsPersonId;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setChangeAmount(BigDecimal changeAmount) 
    {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getChangeAmount() 
    {
        return changeAmount;
    }
    public void setDiscountMoney(BigDecimal discountMoney) 
    {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountMoney() 
    {
        return discountMoney;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
    }
    public void setBillNo(String billNo) 
    {
        this.billNo = billNo;
    }

    public String getBillNo() 
    {
        return billNo;
    }
    public void setBillTime(Date billTime) 
    {
        this.billTime = billTime;
    }

    public Date getBillTime() 
    {
        return billTime;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("type", getType())
            .append("organId", getOrganId())
            .append("handsPersonId", getHandsPersonId())
            .append("creator", getCreator())
            .append("changeAmount", getChangeAmount())
            .append("discountMoney", getDiscountMoney())
            .append("totalPrice", getTotalPrice())
            .append("accountId", getAccountId())
            .append("billNo", getBillNo())
            .append("billTime", getBillTime())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("status", getStatus())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
