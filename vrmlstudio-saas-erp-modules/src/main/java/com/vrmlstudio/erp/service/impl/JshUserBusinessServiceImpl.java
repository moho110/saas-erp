package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshUserBusinessMapper;
import com.vrmlstudio.erp.domain.JshUserBusiness;
import com.vrmlstudio.erp.service.IJshUserBusinessService;

/**
 * 用户/角色/模块关系Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshUserBusinessServiceImpl implements IJshUserBusinessService 
{
    @Autowired
    private JshUserBusinessMapper jshUserBusinessMapper;

    /**
     * 查询用户/角色/模块关系
     * 
     * @param id 用户/角色/模块关系主键
     * @return 用户/角色/模块关系
     */
    @Override
    public JshUserBusiness selectJshUserBusinessById(Long id)
    {
        return jshUserBusinessMapper.selectJshUserBusinessById(id);
    }

    /**
     * 查询用户/角色/模块关系列表
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 用户/角色/模块关系
     */
    @Override
    public List<JshUserBusiness> selectJshUserBusinessList(JshUserBusiness jshUserBusiness)
    {
        return jshUserBusinessMapper.selectJshUserBusinessList(jshUserBusiness);
    }

    /**
     * 新增用户/角色/模块关系
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 结果
     */
    @Override
    public int insertJshUserBusiness(JshUserBusiness jshUserBusiness)
    {
        return jshUserBusinessMapper.insertJshUserBusiness(jshUserBusiness);
    }

    /**
     * 修改用户/角色/模块关系
     * 
     * @param jshUserBusiness 用户/角色/模块关系
     * @return 结果
     */
    @Override
    public int updateJshUserBusiness(JshUserBusiness jshUserBusiness)
    {
        return jshUserBusinessMapper.updateJshUserBusiness(jshUserBusiness);
    }

    /**
     * 批量删除用户/角色/模块关系
     * 
     * @param ids 需要删除的用户/角色/模块关系主键
     * @return 结果
     */
    @Override
    public int deleteJshUserBusinessByIds(Long[] ids)
    {
        return jshUserBusinessMapper.deleteJshUserBusinessByIds(ids);
    }

    /**
     * 删除用户/角色/模块关系信息
     * 
     * @param id 用户/角色/模块关系主键
     * @return 结果
     */
    @Override
    public int deleteJshUserBusinessById(Long id)
    {
        return jshUserBusinessMapper.deleteJshUserBusinessById(id);
    }
}
