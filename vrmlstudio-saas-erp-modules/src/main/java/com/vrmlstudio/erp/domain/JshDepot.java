package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 仓库对象 jsh_depot
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshDepot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String name;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String address;

    /** 仓储费 */
    @Excel(name = "仓储费")
    private BigDecimal warehousing;

    /** 搬运费 */
    @Excel(name = "搬运费")
    private BigDecimal truckage;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long principal;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    /** 是否默认 */
    @Excel(name = "是否默认")
    private Integer isDefault;

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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setWarehousing(BigDecimal warehousing) 
    {
        this.warehousing = warehousing;
    }

    public BigDecimal getWarehousing() 
    {
        return warehousing;
    }
    public void setTruckage(BigDecimal truckage) 
    {
        this.truckage = truckage;
    }

    public BigDecimal getTruckage() 
    {
        return truckage;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setPrincipal(Long principal) 
    {
        this.principal = principal;
    }

    public Long getPrincipal() 
    {
        return principal;
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
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("address", getAddress())
            .append("warehousing", getWarehousing())
            .append("truckage", getTruckage())
            .append("type", getType())
            .append("sort", getSort())
            .append("remark", getRemark())
            .append("principal", getPrincipal())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .append("isDefault", getIsDefault())
            .toString();
    }
}
