package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 功能模块对象 jsh_function
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshFunction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String number;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 上级编号 */
    @Excel(name = "上级编号")
    private String parentNumber;

    /** 链接 */
    @Excel(name = "链接")
    private String url;

    /** 组件 */
    @Excel(name = "组件")
    private String component;

    /** 收缩 */
    @Excel(name = "收缩")
    private Integer state;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 启用 */
    @Excel(name = "启用")
    private Integer enabled;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 功能按钮 */
    @Excel(name = "功能按钮")
    private String pushBtn;

    /** 图标 */
    @Excel(name = "图标")
    private String icon;

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
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParentNumber(String parentNumber) 
    {
        this.parentNumber = parentNumber;
    }

    public String getParentNumber() 
    {
        return parentNumber;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setComponent(String component) 
    {
        this.component = component;
    }

    public String getComponent() 
    {
        return component;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setPushBtn(String pushBtn) 
    {
        this.pushBtn = pushBtn;
    }

    public String getPushBtn() 
    {
        return pushBtn;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
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
            .append("number", getNumber())
            .append("name", getName())
            .append("parentNumber", getParentNumber())
            .append("url", getUrl())
            .append("component", getComponent())
            .append("state", getState())
            .append("sort", getSort())
            .append("enabled", getEnabled())
            .append("type", getType())
            .append("pushBtn", getPushBtn())
            .append("icon", getIcon())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
