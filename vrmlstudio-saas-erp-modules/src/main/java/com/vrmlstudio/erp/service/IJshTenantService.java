package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshTenant;

/**
 * 租户Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshTenantService 
{
    /**
     * 查询租户
     * 
     * @param id 租户主键
     * @return 租户
     */
    public JshTenant selectJshTenantById(Long id);

    /**
     * 查询租户列表
     * 
     * @param jshTenant 租户
     * @return 租户集合
     */
    public List<JshTenant> selectJshTenantList(JshTenant jshTenant);

    /**
     * 新增租户
     * 
     * @param jshTenant 租户
     * @return 结果
     */
    public int insertJshTenant(JshTenant jshTenant);

    /**
     * 修改租户
     * 
     * @param jshTenant 租户
     * @return 结果
     */
    public int updateJshTenant(JshTenant jshTenant);

    /**
     * 批量删除租户
     * 
     * @param ids 需要删除的租户主键集合
     * @return 结果
     */
    public int deleteJshTenantByIds(Long[] ids);

    /**
     * 删除租户信息
     * 
     * @param id 租户主键
     * @return 结果
     */
    public int deleteJshTenantById(Long id);
}
