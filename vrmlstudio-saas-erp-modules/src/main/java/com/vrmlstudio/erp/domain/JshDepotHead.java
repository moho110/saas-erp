package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 单据主对象 jsh_depot_head
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshDepotHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 类型(出库/入库) */
    @Excel(name = "类型(出库/入库)")
    private String type;

    /** 出入库分类 */
    @Excel(name = "出入库分类")
    private String subType;

    /** 初始票据号 */
    @Excel(name = "初始票据号")
    private String defaultNumber;

    /** 票据号 */
    @Excel(name = "票据号")
    private String number;

    /** 出入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operTime;

    /** 供应商id */
    @Excel(name = "供应商id")
    private Long organId;

    /** 操作员 */
    @Excel(name = "操作员")
    private Long creator;

    /** 账户id */
    @Excel(name = "账户id")
    private Long accountId;

    /** 变动金额(收款/付款) */
    @Excel(name = "变动金额(收款/付款)")
    private BigDecimal changeAmount;

    /** 找零金额 */
    @Excel(name = "找零金额")
    private BigDecimal backAmount;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalPrice;

    /** 付款类型(现金、记账等) */
    @Excel(name = "付款类型(现金、记账等)")
    private String payType;

    /** 单据类型 */
    @Excel(name = "单据类型")
    private String billType;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String fileName;

    /** 业务员（可以多个） */
    @Excel(name = "业务员", readConverterExp = "可=以多个")
    private String salesMan;

    /** 多账户ID列表 */
    @Excel(name = "多账户ID列表")
    private String accountIdList;

    /** 多账户金额列表 */
    @Excel(name = "多账户金额列表")
    private String accountMoneyList;

    /** 优惠率 */
    @Excel(name = "优惠率")
    private BigDecimal discount;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private BigDecimal discountMoney;

    /** 优惠后金额 */
    @Excel(name = "优惠后金额")
    private BigDecimal discountLastMoney;

    /** 销售或采购费用合计 */
    @Excel(name = "销售或采购费用合计")
    private BigDecimal otherMoney;

    /** 订金 */
    @Excel(name = "订金")
    private BigDecimal deposit;

    /** 状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售 */
    @Excel(name = "状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售")
    private String status;

    /** 采购状态，0未采购、2完成采购、3部分采购 */
    @Excel(name = "采购状态，0未采购、2完成采购、3部分采购")
    private String purchaseStatus;

    /** 关联订单号 */
    @Excel(name = "关联订单号")
    private String linkNumber;

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
    public void setSubType(String subType) 
    {
        this.subType = subType;
    }

    public String getSubType() 
    {
        return subType;
    }
    public void setDefaultNumber(String defaultNumber) 
    {
        this.defaultNumber = defaultNumber;
    }

    public String getDefaultNumber() 
    {
        return defaultNumber;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setOperTime(Date operTime) 
    {
        this.operTime = operTime;
    }

    public Date getOperTime() 
    {
        return operTime;
    }
    public void setOrganId(Long organId) 
    {
        this.organId = organId;
    }

    public Long getOrganId() 
    {
        return organId;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
    }
    public void setChangeAmount(BigDecimal changeAmount) 
    {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getChangeAmount() 
    {
        return changeAmount;
    }
    public void setBackAmount(BigDecimal backAmount) 
    {
        this.backAmount = backAmount;
    }

    public BigDecimal getBackAmount() 
    {
        return backAmount;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setBillType(String billType) 
    {
        this.billType = billType;
    }

    public String getBillType() 
    {
        return billType;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setSalesMan(String salesMan) 
    {
        this.salesMan = salesMan;
    }

    public String getSalesMan() 
    {
        return salesMan;
    }
    public void setAccountIdList(String accountIdList) 
    {
        this.accountIdList = accountIdList;
    }

    public String getAccountIdList() 
    {
        return accountIdList;
    }
    public void setAccountMoneyList(String accountMoneyList) 
    {
        this.accountMoneyList = accountMoneyList;
    }

    public String getAccountMoneyList() 
    {
        return accountMoneyList;
    }
    public void setDiscount(BigDecimal discount) 
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount() 
    {
        return discount;
    }
    public void setDiscountMoney(BigDecimal discountMoney) 
    {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountMoney() 
    {
        return discountMoney;
    }
    public void setDiscountLastMoney(BigDecimal discountLastMoney) 
    {
        this.discountLastMoney = discountLastMoney;
    }

    public BigDecimal getDiscountLastMoney() 
    {
        return discountLastMoney;
    }
    public void setOtherMoney(BigDecimal otherMoney) 
    {
        this.otherMoney = otherMoney;
    }

    public BigDecimal getOtherMoney() 
    {
        return otherMoney;
    }
    public void setDeposit(BigDecimal deposit) 
    {
        this.deposit = deposit;
    }

    public BigDecimal getDeposit() 
    {
        return deposit;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setPurchaseStatus(String purchaseStatus) 
    {
        this.purchaseStatus = purchaseStatus;
    }

    public String getPurchaseStatus() 
    {
        return purchaseStatus;
    }
    public void setLinkNumber(String linkNumber) 
    {
        this.linkNumber = linkNumber;
    }

    public String getLinkNumber() 
    {
        return linkNumber;
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
            .append("subType", getSubType())
            .append("defaultNumber", getDefaultNumber())
            .append("number", getNumber())
            .append("createTime", getCreateTime())
            .append("operTime", getOperTime())
            .append("organId", getOrganId())
            .append("creator", getCreator())
            .append("accountId", getAccountId())
            .append("changeAmount", getChangeAmount())
            .append("backAmount", getBackAmount())
            .append("totalPrice", getTotalPrice())
            .append("payType", getPayType())
            .append("billType", getBillType())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("salesMan", getSalesMan())
            .append("accountIdList", getAccountIdList())
            .append("accountMoneyList", getAccountMoneyList())
            .append("discount", getDiscount())
            .append("discountMoney", getDiscountMoney())
            .append("discountLastMoney", getDiscountLastMoney())
            .append("otherMoney", getOtherMoney())
            .append("deposit", getDeposit())
            .append("status", getStatus())
            .append("purchaseStatus", getPurchaseStatus())
            .append("linkNumber", getLinkNumber())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
