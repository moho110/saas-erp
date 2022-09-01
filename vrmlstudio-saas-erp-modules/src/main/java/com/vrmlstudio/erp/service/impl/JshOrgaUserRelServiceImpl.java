package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshOrgaUserRelMapper;
import com.vrmlstudio.erp.domain.JshOrgaUserRel;
import com.vrmlstudio.erp.service.IJshOrgaUserRelService;

/**
 * 机构用户关系Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshOrgaUserRelServiceImpl implements IJshOrgaUserRelService 
{
    @Autowired
    private JshOrgaUserRelMapper jshOrgaUserRelMapper;

    /**
     * 查询机构用户关系
     * 
     * @param id 机构用户关系主键
     * @return 机构用户关系
     */
    @Override
    public JshOrgaUserRel selectJshOrgaUserRelById(Long id)
    {
        return jshOrgaUserRelMapper.selectJshOrgaUserRelById(id);
    }

    /**
     * 查询机构用户关系列表
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 机构用户关系
     */
    @Override
    public List<JshOrgaUserRel> selectJshOrgaUserRelList(JshOrgaUserRel jshOrgaUserRel)
    {
        return jshOrgaUserRelMapper.selectJshOrgaUserRelList(jshOrgaUserRel);
    }

    /**
     * 新增机构用户关系
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 结果
     */
    @Override
    public int insertJshOrgaUserRel(JshOrgaUserRel jshOrgaUserRel)
    {
        jshOrgaUserRel.setCreateTime(DateUtils.getNowDate());
        return jshOrgaUserRelMapper.insertJshOrgaUserRel(jshOrgaUserRel);
    }

    /**
     * 修改机构用户关系
     * 
     * @param jshOrgaUserRel 机构用户关系
     * @return 结果
     */
    @Override
    public int updateJshOrgaUserRel(JshOrgaUserRel jshOrgaUserRel)
    {
        jshOrgaUserRel.setUpdateTime(DateUtils.getNowDate());
        return jshOrgaUserRelMapper.updateJshOrgaUserRel(jshOrgaUserRel);
    }

    /**
     * 批量删除机构用户关系
     * 
     * @param ids 需要删除的机构用户关系主键
     * @return 结果
     */
    @Override
    public int deleteJshOrgaUserRelByIds(Long[] ids)
    {
        return jshOrgaUserRelMapper.deleteJshOrgaUserRelByIds(ids);
    }

    /**
     * 删除机构用户关系信息
     * 
     * @param id 机构用户关系主键
     * @return 结果
     */
    @Override
    public int deleteJshOrgaUserRelById(Long id)
    {
        return jshOrgaUserRelMapper.deleteJshOrgaUserRelById(id);
    }
}
