package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshRole;

/**
 * 角色Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshRoleService 
{
    /**
     * 查询角色
     * 
     * @param id 角色主键
     * @return 角色
     */
    public JshRole selectJshRoleById(Long id);

    /**
     * 查询角色列表
     * 
     * @param jshRole 角色
     * @return 角色集合
     */
    public List<JshRole> selectJshRoleList(JshRole jshRole);

    /**
     * 新增角色
     * 
     * @param jshRole 角色
     * @return 结果
     */
    public int insertJshRole(JshRole jshRole);

    /**
     * 修改角色
     * 
     * @param jshRole 角色
     * @return 结果
     */
    public int updateJshRole(JshRole jshRole);

    /**
     * 批量删除角色
     * 
     * @param ids 需要删除的角色主键集合
     * @return 结果
     */
    public int deleteJshRoleByIds(Long[] ids);

    /**
     * 删除角色信息
     * 
     * @param id 角色主键
     * @return 结果
     */
    public int deleteJshRoleById(Long id);
}
