package com.vrmlstudio.erp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 租户对象 jsh_tenant
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshTenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long tenantId;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;

    /** 用户数量限制 */
    @Excel(name = "用户数量限制")
    private Long userNumLimit;

    /** 租户类型，0免费租户，1付费租户 */
    @Excel(name = "租户类型，0免费租户，1付费租户")
    private String type;

    /** 启用 0-禁用  1-启用 */
    @Excel(name = "启用 0-禁用  1-启用")
    private Integer enabled;

    /** 到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setUserNumLimit(Long userNumLimit) 
    {
        this.userNumLimit = userNumLimit;
    }

    public Long getUserNumLimit() 
    {
        return userNumLimit;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setExpireTime(Date expireTime) 
    {
        this.expireTime = expireTime;
    }

    public Date getExpireTime() 
    {
        return expireTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tenantId", getTenantId())
            .append("loginName", getLoginName())
            .append("userNumLimit", getUserNumLimit())
            .append("type", getType())
            .append("enabled", getEnabled())
            .append("createTime", getCreateTime())
            .append("expireTime", getExpireTime())
            .append("remark", getRemark())
            .toString();
    }
}
