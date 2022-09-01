package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshTenantMapper;
import com.vrmlstudio.erp.domain.JshTenant;
import com.vrmlstudio.erp.service.IJshTenantService;

/**
 * 租户Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshTenantServiceImpl implements IJshTenantService 
{
    @Autowired
    private JshTenantMapper jshTenantMapper;

    /**
     * 查询租户
     * 
     * @param id 租户主键
     * @return 租户
     */
    @Override
    public JshTenant selectJshTenantById(Long id)
    {
        return jshTenantMapper.selectJshTenantById(id);
    }

    /**
     * 查询租户列表
     * 
     * @param jshTenant 租户
     * @return 租户
     */
    @Override
    public List<JshTenant> selectJshTenantList(JshTenant jshTenant)
    {
        return jshTenantMapper.selectJshTenantList(jshTenant);
    }

    /**
     * 新增租户
     * 
     * @param jshTenant 租户
     * @return 结果
     */
    @Override
    public int insertJshTenant(JshTenant jshTenant)
    {
        jshTenant.setCreateTime(DateUtils.getNowDate());
        return jshTenantMapper.insertJshTenant(jshTenant);
    }

    /**
     * 修改租户
     * 
     * @param jshTenant 租户
     * @return 结果
     */
    @Override
    public int updateJshTenant(JshTenant jshTenant)
    {
        return jshTenantMapper.updateJshTenant(jshTenant);
    }

    /**
     * 批量删除租户
     * 
     * @param ids 需要删除的租户主键
     * @return 结果
     */
    @Override
    public int deleteJshTenantByIds(Long[] ids)
    {
        return jshTenantMapper.deleteJshTenantByIds(ids);
    }

    /**
     * 删除租户信息
     * 
     * @param id 租户主键
     * @return 结果
     */
    @Override
    public int deleteJshTenantById(Long id)
    {
        return jshTenantMapper.deleteJshTenantById(id);
    }
}
