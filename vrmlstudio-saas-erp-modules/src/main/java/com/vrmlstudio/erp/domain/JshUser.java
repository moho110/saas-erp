package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 用户对象 jsh_user
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户姓名--例如张三 */
    @Excel(name = "用户姓名--例如张三")
    private String username;

    /** 登录用户名 */
    @Excel(name = "登录用户名")
    private String loginName;

    /** 登陆密码 */
    @Excel(name = "登陆密码")
    private String password;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenum;

    /** 是否为管理者 0==管理者 1==员工 */
    @Excel(name = "是否为管理者 0==管理者 1==员工")
    private Integer ismanager;

    /** 是否系统自带数据  */
    @Excel(name = "是否系统自带数据 ")
    private Integer isystem;

    /** 状态，0：正常，1：删除，2封禁 */
    @Excel(name = "状态，0：正常，1：删除，2封禁")
    private Integer status;

    /** 用户描述信息 */
    @Excel(name = "用户描述信息")
    private String description;

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
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhonenum(String phonenum) 
    {
        this.phonenum = phonenum;
    }

    public String getPhonenum() 
    {
        return phonenum;
    }
    public void setIsmanager(Integer ismanager) 
    {
        this.ismanager = ismanager;
    }

    public Integer getIsmanager() 
    {
        return ismanager;
    }
    public void setIsystem(Integer isystem) 
    {
        this.isystem = isystem;
    }

    public Integer getIsystem() 
    {
        return isystem;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("username", getUsername())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("position", getPosition())
            .append("department", getDepartment())
            .append("email", getEmail())
            .append("phonenum", getPhonenum())
            .append("ismanager", getIsmanager())
            .append("isystem", getIsystem())
            .append("status", getStatus())
            .append("description", getDescription())
            .append("remark", getRemark())
            .append("tenantId", getTenantId())
            .toString();
    }
}
