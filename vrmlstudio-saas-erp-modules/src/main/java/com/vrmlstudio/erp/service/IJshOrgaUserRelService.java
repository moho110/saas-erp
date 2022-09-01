package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshOrgaUserRel;

/**
 * 机构用户关系Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshOrgaUserRelService 
{
    /**
     * 查询机构用户关系
     * 
     * @param id 机构用户关系主键
     * @return 机构用户关系
     */
    public JshOrgaUserRel selectJshOrgaUserRelById(Long id);

    /**
     * 查询机构用户关系列表
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 机构用户关系集合
     */
    public List<JshOrgaUserRel> selectJshOrgaUserRelList(JshOrgaUserRel jshOrgaUserRel);

    /**
     * 新增机构用户关系
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 结果
     */
    public int insertJshOrgaUserRel(JshOrgaUserRel jshOrgaUserRel);

    /**
     * 修改机构用户关系
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 结果
     */
    public int updateJshOrgaUserRel(JshOrgaUserRel jshOrgaUserRel);

    /**
     * 批量删除机构用户关系
     * 
     * @param ids 需要删除的机构用户关系主键集合
     * @return 结果
     */
    public int deleteJshOrgaUserRelByIds(Long[] ids);

    /**
     * 删除机构用户关系信息
     * 
     * @param id 机构用户关系主键
     * @return 结果
     */
    public int deleteJshOrgaUserRelById(Long id);
}
