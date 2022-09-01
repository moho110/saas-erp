package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 消息对象 jsh_msg
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshMsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 消息标题 */
    @Excel(name = "消息标题")
    private String msgTitle;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String msgContent;

    /** 消息类型 */
    @Excel(name = "消息类型")
    private String type;

    /** 状态，1未读 2已读 */
    @Excel(name = "状态，1未读 2已读")
    private String status;

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
    public void setMsgTitle(String msgTitle) 
    {
        this.msgTitle = msgTitle;
    }

    public String getMsgTitle() 
    {
        return msgTitle;
    }
    public void setMsgContent(String msgContent) 
    {
        this.msgContent = msgContent;
    }

    public String getMsgContent() 
    {
        return msgContent;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("msgTitle", getMsgTitle())
            .append("msgContent", getMsgContent())
            .append("createTime", getCreateTime())
            .append("type", getType())
            .append("status", getStatus())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
