package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 账户信息对象 jsh_account
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 编号 */
    @Excel(name = "编号")
    private String serialNo;

    /** 期初金额 */
    @Excel(name = "期初金额")
    private BigDecimal initialAmount;

    /** 当前余额 */
    @Excel(name = "当前余额")
    private BigDecimal currentAmount;

    /** 是否默认 */
    @Excel(name = "是否默认")
    private Integer isDefault;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSerialNo(String serialNo) 
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo() 
    {
        return serialNo;
    }
    public void setInitialAmount(BigDecimal initialAmount) 
    {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getInitialAmount() 
    {
        return initialAmount;
    }
    public void setCurrentAmount(BigDecimal currentAmount) 
    {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getCurrentAmount() 
    {
        return currentAmount;
    }
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
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
            .append("name", getName())
            .append("serialNo", getSerialNo())
            .append("initialAmount", getInitialAmount())
            .append("currentAmount", getCurrentAmount())
            .append("remark", getRemark())
            .append("isDefault", getIsDefault())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
