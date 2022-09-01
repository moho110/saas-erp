package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 机构用户关系对象 jsh_orga_user_rel
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshOrgaUserRel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 机构id */
    @Excel(name = "机构id")
    private Long orgaId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户在所属机构中显示顺序 */
    @Excel(name = "用户在所属机构中显示顺序")
    private String userBlngOrgaDsplSeq;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private Long updater;

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
    public void setOrgaId(Long orgaId) 
    {
        this.orgaId = orgaId;
    }

    public Long getOrgaId() 
    {
        return orgaId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserBlngOrgaDsplSeq(String userBlngOrgaDsplSeq) 
    {
        this.userBlngOrgaDsplSeq = userBlngOrgaDsplSeq;
    }

    public String getUserBlngOrgaDsplSeq() 
    {
        return userBlngOrgaDsplSeq;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setUpdater(Long updater) 
    {
        this.updater = updater;
    }

    public Long getUpdater() 
    {
        return updater;
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
            .append("orgaId", getOrgaId())
            .append("userId", getUserId())
            .append("userBlngOrgaDsplSeq", getUserBlngOrgaDsplSeq())
            .append("deleteFlag", getDeleteFlag())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("updateTime", getUpdateTime())
            .append("updater", getUpdater())
            .append("tenantId", getTenantId())
            .toString();
    }
}
