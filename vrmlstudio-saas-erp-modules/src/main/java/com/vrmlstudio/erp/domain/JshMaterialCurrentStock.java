package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 产品当前库存对象 jsh_material_current_stock
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMaterialCurrentStock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 产品id */
    @Excel(name = "产品id")
    private Long materialId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long depotId;

    /** 当前库存数量 */
    @Excel(name = "当前库存数量")
    private BigDecimal currentNumber;

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
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setCurrentNumber(BigDecimal currentNumber) 
    {
        this.currentNumber = currentNumber;
    }

    public BigDecimal getCurrentNumber() 
    {
        return currentNumber;
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
            .append("materialId", getMaterialId())
            .append("depotId", getDepotId())
            .append("currentNumber", getCurrentNumber())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
