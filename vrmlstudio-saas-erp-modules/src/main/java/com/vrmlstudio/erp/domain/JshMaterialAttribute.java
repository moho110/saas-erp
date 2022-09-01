package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 产品属性对象 jsh_material_attribute
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMaterialAttribute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 属性字段 */
    @Excel(name = "属性字段")
    private String attributeField;

    /** 属性名 */
    @Excel(name = "属性名")
    private String attributeName;

    /** 属性值 */
    @Excel(name = "属性值")
    private String attributeValue;

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
    public void setAttributeField(String attributeField) 
    {
        this.attributeField = attributeField;
    }

    public String getAttributeField() 
    {
        return attributeField;
    }
    public void setAttributeName(String attributeName) 
    {
        this.attributeName = attributeName;
    }

    public String getAttributeName() 
    {
        return attributeName;
    }
    public void setAttributeValue(String attributeValue) 
    {
        this.attributeValue = attributeValue;
    }

    public String getAttributeValue() 
    {
        return attributeValue;
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
            .append("attributeField", getAttributeField())
            .append("attributeName", getAttributeName())
            .append("attributeValue", getAttributeValue())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
