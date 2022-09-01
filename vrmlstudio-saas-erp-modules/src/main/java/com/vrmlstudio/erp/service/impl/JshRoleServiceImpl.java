package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshRoleMapper;
import com.vrmlstudio.erp.domain.JshRole;
import com.vrmlstudio.erp.service.IJshRoleService;

/**
 * 角色Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshRoleServiceImpl implements IJshRoleService 
{
    @Autowired
    private JshRoleMapper jshRoleMapper;

    /**
     * 查询角色
     * 
     * @param id 角色主键
     * @return 角色
     */
    @Override
    public JshRole selectJshRoleById(Long id)
    {
        return jshRoleMapper.selectJshRoleById(id);
    }

    /**
     * 查询角色列表
     * 
     * @param jshRole 角色
     * @return 角色
     */
    @Override
    public List<JshRole> selectJshRoleList(JshRole jshRole)
    {
        return jshRoleMapper.selectJshRoleList(jshRole);
    }

    /**
     * 新增角色
     * 
     * @param jshRole 角色
     * @return 结果
     */
    @Override
    public int insertJshRole(JshRole jshRole)
    {
        return jshRoleMapper.insertJshRole(jshRole);
    }

    /**
     * 修改角色
     * 
     * @param jshRole 角色
     * @return 结果
     */
    @Override
    public int updateJshRole(JshRole jshRole)
    {
        return jshRoleMapper.updateJshRole(jshRole);
    }

    /**
     * 批量删除角色
     * 
     * @param ids 需要删除的角色主键
     * @return 结果
     */
    @Override
    public int deleteJshRoleByIds(Long[] ids)
    {
        return jshRoleMapper.deleteJshRoleByIds(ids);
    }

    /**
     * 删除角色信息
     * 
     * @param id 角色主键
     * @return 结果
     */
    @Override
    public int deleteJshRoleById(Long id)
    {
        return jshRoleMapper.deleteJshRoleById(id);
    }
}
