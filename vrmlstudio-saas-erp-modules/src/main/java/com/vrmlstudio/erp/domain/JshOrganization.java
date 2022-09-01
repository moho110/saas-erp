package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.TreeEntity;

/**
 * 机构对象 jsh_organization
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshOrganization extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 机构编号 */
    @Excel(name = "机构编号")
    private String orgNo;

    /** 机构简称 */
    @Excel(name = "机构简称")
    private String orgAbr;

    /** 机构显示顺序 */
    @Excel(name = "机构显示顺序")
    private String sort;

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
    public void setOrgNo(String orgNo) 
    {
        this.orgNo = orgNo;
    }

    public String getOrgNo() 
    {
        return orgNo;
    }
    public void setOrgAbr(String orgAbr) 
    {
        this.orgAbr = orgAbr;
    }

    public String getOrgAbr() 
    {
        return orgAbr;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
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
            .append("orgNo", getOrgNo())
            .append("orgAbr", getOrgAbr())
            .append("parentId", getParentId())
            .append("sort", getSort())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
