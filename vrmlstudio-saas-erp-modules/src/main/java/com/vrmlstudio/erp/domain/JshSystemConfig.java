package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 系统参数对象 jsh_system_config
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshSystemConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司联系人 */
    @Excel(name = "公司联系人")
    private String companyContacts;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String companyAddress;

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String companyTel;

    /** 公司传真 */
    @Excel(name = "公司传真")
    private String companyFax;

    /** 公司邮编 */
    @Excel(name = "公司邮编")
    private String companyPostCode;

    /** 销售协议 */
    @Excel(name = "销售协议")
    private String saleAgreement;

    /** 仓库启用标记，0未启用，1启用 */
    @Excel(name = "仓库启用标记，0未启用，1启用")
    private String depotFlag;

    /** 客户启用标记，0未启用，1启用 */
    @Excel(name = "客户启用标记，0未启用，1启用")
    private String customerFlag;

    /** 负库存启用标记，0未启用，1启用 */
    @Excel(name = "负库存启用标记，0未启用，1启用")
    private String minusStockFlag;

    /** 以销定购启用标记，0未启用，1启用 */
    @Excel(name = "以销定购启用标记，0未启用，1启用")
    private String purchaseBySaleFlag;

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
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyContacts(String companyContacts) 
    {
        this.companyContacts = companyContacts;
    }

    public String getCompanyContacts() 
    {
        return companyContacts;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyTel(String companyTel) 
    {
        this.companyTel = companyTel;
    }

    public String getCompanyTel() 
    {
        return companyTel;
    }
    public void setCompanyFax(String companyFax) 
    {
        this.companyFax = companyFax;
    }

    public String getCompanyFax() 
    {
        return companyFax;
    }
    public void setCompanyPostCode(String companyPostCode) 
    {
        this.companyPostCode = companyPostCode;
    }

    public String getCompanyPostCode() 
    {
        return companyPostCode;
    }
    public void setSaleAgreement(String saleAgreement) 
    {
        this.saleAgreement = saleAgreement;
    }

    public String getSaleAgreement() 
    {
        return saleAgreement;
    }
    public void setDepotFlag(String depotFlag) 
    {
        this.depotFlag = depotFlag;
    }

    public String getDepotFlag() 
    {
        return depotFlag;
    }
    public void setCustomerFlag(String customerFlag) 
    {
        this.customerFlag = customerFlag;
    }

    public String getCustomerFlag() 
    {
        return customerFlag;
    }
    public void setMinusStockFlag(String minusStockFlag) 
    {
        this.minusStockFlag = minusStockFlag;
    }

    public String getMinusStockFlag() 
    {
        return minusStockFlag;
    }
    public void setPurchaseBySaleFlag(String purchaseBySaleFlag) 
    {
        this.purchaseBySaleFlag = purchaseBySaleFlag;
    }

    public String getPurchaseBySaleFlag() 
    {
        return purchaseBySaleFlag;
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
            .append("companyName", getCompanyName())
            .append("companyContacts", getCompanyContacts())
            .append("companyAddress", getCompanyAddress())
            .append("companyTel", getCompanyTel())
            .append("companyFax", getCompanyFax())
            .append("companyPostCode", getCompanyPostCode())
            .append("saleAgreement", getSaleAgreement())
            .append("depotFlag", getDepotFlag())
            .append("customerFlag", getCustomerFlag())
            .append("minusStockFlag", getMinusStockFlag())
            .append("purchaseBySaleFlag", getPurchaseBySaleFlag())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
