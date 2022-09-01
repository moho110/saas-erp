package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 产品扩展字段对象 jsh_material_property
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMaterialProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 原始名称 */
    @Excel(name = "原始名称")
    private String nativeName;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private Integer enabled;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 别名 */
    @Excel(name = "别名")
    private String anotherName;

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
    public void setNativeName(String nativeName) 
    {
        this.nativeName = nativeName;
    }

    public String getNativeName() 
    {
        return nativeName;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setAnotherName(String anotherName) 
    {
        this.anotherName = anotherName;
    }

    public String getAnotherName() 
    {
        return anotherName;
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
            .append("nativeName", getNativeName())
            .append("enabled", getEnabled())
            .append("sort", getSort())
            .append("anotherName", getAnotherName())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
