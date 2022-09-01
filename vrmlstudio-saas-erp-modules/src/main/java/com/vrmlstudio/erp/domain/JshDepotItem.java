package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 单据子对象 jsh_depot_item
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshDepotItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 表头Id */
    @Excel(name = "表头Id")
    private Long headerId;

    /** 商品Id */
    @Excel(name = "商品Id")
    private Long materialId;

    /** 商品扩展id */
    @Excel(name = "商品扩展id")
    private Long materialExtendId;

    /** 商品计量单位 */
    @Excel(name = "商品计量单位")
    private String materialUnit;

    /** 多属性 */
    @Excel(name = "多属性")
    private String sku;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal operNumber;

    /** 基础数量，如kg、瓶 */
    @Excel(name = "基础数量，如kg、瓶")
    private BigDecimal basicNumber;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 含税单价 */
    @Excel(name = "含税单价")
    private BigDecimal taxUnitPrice;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal allPrice;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long depotId;

    /** 调拨时，对方仓库Id */
    @Excel(name = "调拨时，对方仓库Id")
    private Long anotherDepotId;

    /** 税率 */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /** 税额 */
    @Excel(name = "税额")
    private BigDecimal taxMoney;

    /** 价税合计 */
    @Excel(name = "价税合计")
    private BigDecimal taxLastMoney;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String materialType;

    /** 序列号列表 */
    @Excel(name = "序列号列表")
    private String snList;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 有效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expirationDate;

    /** 关联明细id */
    @Excel(name = "关联明细id")
    private Long linkId;

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
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialExtendId(Long materialExtendId) 
    {
        this.materialExtendId = materialExtendId;
    }

    public Long getMaterialExtendId() 
    {
        return materialExtendId;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setSku(String sku) 
    {
        this.sku = sku;
    }

    public String getSku() 
    {
        return sku;
    }
    public void setOperNumber(BigDecimal operNumber) 
    {
        this.operNumber = operNumber;
    }

    public BigDecimal getOperNumber() 
    {
        return operNumber;
    }
    public void setBasicNumber(BigDecimal basicNumber) 
    {
        this.basicNumber = basicNumber;
    }

    public BigDecimal getBasicNumber() 
    {
        return basicNumber;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setTaxUnitPrice(BigDecimal taxUnitPrice) 
    {
        this.taxUnitPrice = taxUnitPrice;
    }

    public BigDecimal getTaxUnitPrice() 
    {
        return taxUnitPrice;
    }
    public void setAllPrice(BigDecimal allPrice) 
    {
        this.allPrice = allPrice;
    }

    public BigDecimal getAllPrice() 
    {
        return allPrice;
    }
    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setAnotherDepotId(Long anotherDepotId) 
    {
        this.anotherDepotId = anotherDepotId;
    }

    public Long getAnotherDepotId() 
    {
        return anotherDepotId;
    }
    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
    }
    public void setTaxMoney(BigDecimal taxMoney) 
    {
        this.taxMoney = taxMoney;
    }

    public BigDecimal getTaxMoney() 
    {
        return taxMoney;
    }
    public void setTaxLastMoney(BigDecimal taxLastMoney) 
    {
        this.taxLastMoney = taxLastMoney;
    }

    public BigDecimal getTaxLastMoney() 
    {
        return taxLastMoney;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setSnList(String snList) 
    {
        this.snList = snList;
    }

    public String getSnList() 
    {
        return snList;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setExpirationDate(Date expirationDate) 
    {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() 
    {
        return expirationDate;
    }
    public void setLinkId(Long linkId) 
    {
        this.linkId = linkId;
    }

    public Long getLinkId() 
    {
        return linkId;
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
            .append("materialId", getMaterialId())
            .append("materialExtendId", getMaterialExtendId())
            .append("materialUnit", getMaterialUnit())
            .append("sku", getSku())
            .append("operNumber", getOperNumber())
            .append("basicNumber", getBasicNumber())
            .append("unitPrice", getUnitPrice())
            .append("taxUnitPrice", getTaxUnitPrice())
            .append("allPrice", getAllPrice())
            .append("remark", getRemark())
            .append("depotId", getDepotId())
            .append("anotherDepotId", getAnotherDepotId())
            .append("taxRate", getTaxRate())
            .append("taxMoney", getTaxMoney())
            .append("taxLastMoney", getTaxLastMoney())
            .append("materialType", getMaterialType())
            .append("snList", getSnList())
            .append("batchNumber", getBatchNumber())
            .append("expirationDate", getExpirationDate())
            .append("linkId", getLinkId())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
