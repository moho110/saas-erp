package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshUserBusiness;

/**
 * 用户/角色/模块关系Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshUserBusinessService 
{
    /**
     * 查询用户/角色/模块关系
     * 
     * @param id 用户/角色/模块关系主键
     * @return 用户/角色/模块关系
     */
    public JshUserBusiness selectJshUserBusinessById(Long id);

    /**
     * 查询用户/角色/模块关系列表
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 用户/角色/模块关系集合
     */
    public List<JshUserBusiness> selectJshUserBusinessList(JshUserBusiness jshUserBusiness);

    /**
     * 新增用户/角色/模块关系
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 结果
     */
    public int insertJshUserBusiness(JshUserBusiness jshUserBusiness);

    /**
     * 修改用户/角色/模块关系
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 结果
     */
    public int updateJshUserBusiness(JshUserBusiness jshUserBusiness);

    /**
     * 批量删除用户/角色/模块关系
     * 
     * @param ids 需要删除的用户/角色/模块关系主键集合
     * @return 结果
     */
    public int deleteJshUserBusinessByIds(Long[] ids);

    /**
     * 删除用户/角色/模块关系信息
     * 
     * @param id 用户/角色/模块关系主键
     * @return 结果
     */
    public int deleteJshUserBusinessById(Long id);
}
