package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 用户/角色/模块关系对象 jsh_user_business
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshUserBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 类别 */
    @Excel(name = "类别")
    private String type;

    /** 主id */
    @Excel(name = "主id")
    private String keyId;

    /** 值 */
    @Excel(name = "值")
    private String value;

    /** 按钮权限 */
    @Excel(name = "按钮权限")
    private String btnStr;

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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setKeyId(String keyId) 
    {
        this.keyId = keyId;
    }

    public String getKeyId() 
    {
        return keyId;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }
    public void setBtnStr(String btnStr) 
    {
        this.btnStr = btnStr;
    }

    public String getBtnStr() 
    {
        return btnStr;
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
            .append("type", getType())
            .append("keyId", getKeyId())
            .append("value", getValue())
            .append("btnStr", getBtnStr())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
