package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 操作日志对象 jsh_log
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 操作模块名称 */
    @Excel(name = "操作模块名称")
    private String operation;

    /** 客户端IP */
    @Excel(name = "客户端IP")
    private String clientIp;

    /** 操作状态 0==成功，1==失败 */
    @Excel(name = "操作状态 0==成功，1==失败")
    private Integer status;

    /** 详情 */
    @Excel(name = "详情")
    private String content;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOperation(String operation) 
    {
        this.operation = operation;
    }

    public String getOperation() 
    {
        return operation;
    }
    public void setClientIp(String clientIp) 
    {
        this.clientIp = clientIp;
    }

    public String getClientIp() 
    {
        return clientIp;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("operation", getOperation())
            .append("clientIp", getClientIp())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("content", getContent())
            .append("tenantId", getTenantId())
            .toString();
    }
}
