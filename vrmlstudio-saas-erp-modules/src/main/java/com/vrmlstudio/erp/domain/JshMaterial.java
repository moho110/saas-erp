package com.vrmlstudio.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 产品对象 jsh_material
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 产品类型id */
    @Excel(name = "产品类型id")
    private Long categoryId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 制造商 */
    @Excel(name = "制造商")
    private String mfrs;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 规格 */
    @Excel(name = "规格")
    private String standard;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;

    /** 单位-单个 */
    @Excel(name = "单位-单个")
    private String unit;

    /** 图片名称 */
    @Excel(name = "图片名称")
    private String imgName;

    /** 计量单位Id */
    @Excel(name = "计量单位Id")
    private Long unitId;

    /** 保质期天数 */
    @Excel(name = "保质期天数")
    private Integer expiryNum;

    /** 基础重量(kg) */
    @Excel(name = "基础重量(kg)")
    private BigDecimal weight;

    /** 启用 0-禁用  1-启用 */
    @Excel(name = "启用 0-禁用  1-启用")
    private Integer enabled;

    /** 自定义1 */
    @Excel(name = "自定义1")
    private String otherField1;

    /** 自定义2 */
    @Excel(name = "自定义2")
    private String otherField2;

    /** 自定义3 */
    @Excel(name = "自定义3")
    private String otherField3;

    /** 是否开启序列号，0否，1是 */
    @Excel(name = "是否开启序列号，0否，1是")
    private String enableSerialNumber;

    /** 是否开启批号，0否，1是 */
    @Excel(name = "是否开启批号，0否，1是")
    private String enableBatchNumber;

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
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMfrs(String mfrs) 
    {
        this.mfrs = mfrs;
    }

    public String getMfrs() 
    {
        return mfrs;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setStandard(String standard) 
    {
        this.standard = standard;
    }

    public String getStandard() 
    {
        return standard;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setImgName(String imgName) 
    {
        this.imgName = imgName;
    }

    public String getImgName() 
    {
        return imgName;
    }
    public void setUnitId(Long unitId) 
    {
        this.unitId = unitId;
    }

    public Long getUnitId() 
    {
        return unitId;
    }
    public void setExpiryNum(Integer expiryNum) 
    {
        this.expiryNum = expiryNum;
    }

    public Integer getExpiryNum() 
    {
        return expiryNum;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setOtherField1(String otherField1) 
    {
        this.otherField1 = otherField1;
    }

    public String getOtherField1() 
    {
        return otherField1;
    }
    public void setOtherField2(String otherField2) 
    {
        this.otherField2 = otherField2;
    }

    public String getOtherField2() 
    {
        return otherField2;
    }
    public void setOtherField3(String otherField3) 
    {
        this.otherField3 = otherField3;
    }

    public String getOtherField3() 
    {
        return otherField3;
    }
    public void setEnableSerialNumber(String enableSerialNumber) 
    {
        this.enableSerialNumber = enableSerialNumber;
    }

    public String getEnableSerialNumber() 
    {
        return enableSerialNumber;
    }
    public void setEnableBatchNumber(String enableBatchNumber) 
    {
        this.enableBatchNumber = enableBatchNumber;
    }

    public String getEnableBatchNumber() 
    {
        return enableBatchNumber;
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
            .append("categoryId", getCategoryId())
            .append("name", getName())
            .append("mfrs", getMfrs())
            .append("model", getModel())
            .append("standard", getStandard())
            .append("color", getColor())
            .append("unit", getUnit())
            .append("remark", getRemark())
            .append("imgName", getImgName())
            .append("unitId", getUnitId())
            .append("expiryNum", getExpiryNum())
            .append("weight", getWeight())
            .append("enabled", getEnabled())
            .append("otherField1", getOtherField1())
            .append("otherField2", getOtherField2())
            .append("otherField3", getOtherField3())
            .append("enableSerialNumber", getEnableSerialNumber())
            .append("enableBatchNumber", getEnableBatchNumber())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
