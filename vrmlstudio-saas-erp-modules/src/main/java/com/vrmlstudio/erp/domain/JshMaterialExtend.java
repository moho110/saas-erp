package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 产品价格扩展对象 jsh_material_extend
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMaterialExtend extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long materialId;

    /** 商品条码 */
    @Excel(name = "商品条码")
    private String barCode;

    /** 商品单位 */
    @Excel(name = "商品单位")
    private String commodityUnit;

    /** 多属性 */
    @Excel(name = "多属性")
    private String sku;

    /** 采购价格 */
    @Excel(name = "采购价格")
    private BigDecimal purchaseDecimal;

    /** 零售价格 */
    @Excel(name = "零售价格")
    private BigDecimal commodityDecimal;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private BigDecimal wholesaleDecimal;

    /** 最低售价 */
    @Excel(name = "最低售价")
    private BigDecimal lowDecimal;

    /** 是否为默认单位，1是，0否 */
    @Excel(name = "是否为默认单位，1是，0否")
    private String defaultFlag;

    /** 创建人编码 */
    @Excel(name = "创建人编码")
    private String createSerial;

    /** 更新人编码 */
    @Excel(name = "更新人编码")
    private String updateSerial;

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
    public void setBarCode(String barCode) 
    {
        this.barCode = barCode;
    }

    public String getBarCode() 
    {
        return barCode;
    }
    public void setCommodityUnit(String commodityUnit) 
    {
        this.commodityUnit = commodityUnit;
    }

    public String getCommodityUnit() 
    {
        return commodityUnit;
    }
    public void setSku(String sku) 
    {
        this.sku = sku;
    }

    public String getSku() 
    {
        return sku;
    }
    public void setPurchaseDecimal(BigDecimal purchaseDecimal) 
    {
        this.purchaseDecimal = purchaseDecimal;
    }

    public BigDecimal getPurchaseDecimal() 
    {
        return purchaseDecimal;
    }
    public void setCommodityDecimal(BigDecimal commodityDecimal) 
    {
        this.commodityDecimal = commodityDecimal;
    }

    public BigDecimal getCommodityDecimal() 
    {
        return commodityDecimal;
    }
    public void setWholesaleDecimal(BigDecimal wholesaleDecimal) 
    {
        this.wholesaleDecimal = wholesaleDecimal;
    }

    public BigDecimal getWholesaleDecimal() 
    {
        return wholesaleDecimal;
    }
    public void setLowDecimal(BigDecimal lowDecimal) 
    {
        this.lowDecimal = lowDecimal;
    }

    public BigDecimal getLowDecimal() 
    {
        return lowDecimal;
    }
    public void setDefaultFlag(String defaultFlag) 
    {
        this.defaultFlag = defaultFlag;
    }

    public String getDefaultFlag() 
    {
        return defaultFlag;
    }
    public void setCreateSerial(String createSerial) 
    {
        this.createSerial = createSerial;
    }

    public String getCreateSerial() 
    {
        return createSerial;
    }
    public void setUpdateSerial(String updateSerial) 
    {
        this.updateSerial = updateSerial;
    }

    public String getUpdateSerial() 
    {
        return updateSerial;
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
            .append("barCode", getBarCode())
            .append("commodityUnit", getCommodityUnit())
            .append("sku", getSku())
            .append("purchaseDecimal", getPurchaseDecimal())
            .append("commodityDecimal", getCommodityDecimal())
            .append("wholesaleDecimal", getWholesaleDecimal())
            .append("lowDecimal", getLowDecimal())
            .append("defaultFlag", getDefaultFlag())
            .append("createTime", getCreateTime())
            .append("createSerial", getCreateSerial())
            .append("updateSerial", getUpdateSerial())
            .append("updateTime", getUpdateTime())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
