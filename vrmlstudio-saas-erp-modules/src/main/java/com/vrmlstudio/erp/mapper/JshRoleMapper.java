package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshRole;

/**
 * 角色Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshRoleMapper 
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
     * 删除角色
     * 
     * @param id 角色主键
     * @return 结果
     */
    public int deleteJshRoleById(Long id);

    /**
     * 批量删除角色
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshRoleByIds(Long[] ids);
}
