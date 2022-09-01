package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 多单位对象 jsh_unit
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshUnit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称，支持多单位 */
    @Excel(name = "名称，支持多单位")
    private String name;

    /** 基础单位 */
    @Excel(name = "基础单位")
    private String basicUnit;

    /** 副单位 */
    @Excel(name = "副单位")
    private String otherUnit;

    /** 副单位2 */
    @Excel(name = "副单位2")
    private String otherUnitTwo;

    /** 副单位3 */
    @Excel(name = "副单位3")
    private String otherUnitThree;

    /** 比例 */
    @Excel(name = "比例")
    private Long ratio;

    /** 比例2 */
    @Excel(name = "比例2")
    private Long ratioTwo;

    /** 比例3 */
    @Excel(name = "比例3")
    private Long ratioThree;

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
    public void setBasicUnit(String basicUnit) 
    {
        this.basicUnit = basicUnit;
    }

    public String getBasicUnit() 
    {
        return basicUnit;
    }
    public void setOtherUnit(String otherUnit) 
    {
        this.otherUnit = otherUnit;
    }

    public String getOtherUnit() 
    {
        return otherUnit;
    }
    public void setOtherUnitTwo(String otherUnitTwo) 
    {
        this.otherUnitTwo = otherUnitTwo;
    }

    public String getOtherUnitTwo() 
    {
        return otherUnitTwo;
    }
    public void setOtherUnitThree(String otherUnitThree) 
    {
        this.otherUnitThree = otherUnitThree;
    }

    public String getOtherUnitThree() 
    {
        return otherUnitThree;
    }
    public void setRatio(Long ratio) 
    {
        this.ratio = ratio;
    }

    public Long getRatio() 
    {
        return ratio;
    }
    public void setRatioTwo(Long ratioTwo) 
    {
        this.ratioTwo = ratioTwo;
    }

    public Long getRatioTwo() 
    {
        return ratioTwo;
    }
    public void setRatioThree(Long ratioThree) 
    {
        this.ratioThree = ratioThree;
    }

    public Long getRatioThree() 
    {
        return ratioThree;
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
            .append("basicUnit", getBasicUnit())
            .append("otherUnit", getOtherUnit())
            .append("otherUnitTwo", getOtherUnitTwo())
            .append("otherUnitThree", getOtherUnitThree())
            .append("ratio", getRatio())
            .append("ratioTwo", getRatioTwo())
            .append("ratioThree", getRatioThree())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
