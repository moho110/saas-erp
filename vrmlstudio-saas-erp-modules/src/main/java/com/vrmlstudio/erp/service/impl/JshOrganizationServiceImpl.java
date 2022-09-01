package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshOrganizationMapper;
import com.vrmlstudio.erp.domain.JshOrganization;
import com.vrmlstudio.erp.service.IJshOrganizationService;

/**
 * 机构Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshOrganizationServiceImpl implements IJshOrganizationService 
{
    @Autowired
    private JshOrganizationMapper jshOrganizationMapper;

    /**
     * 查询机构
     * 
     * @param id 机构主键
     * @return 机构
     */
    @Override
    public JshOrganization selectJshOrganizationById(Long id)
    {
        return jshOrganizationMapper.selectJshOrganizationById(id);
    }

    /**
     * 查询机构列表
     * 
     * @param jshOrganization 机构
     * @return 机构
     */
    @Override
    public List<JshOrganization> selectJshOrganizationList(JshOrganization jshOrganization)
    {
        return jshOrganizationMapper.selectJshOrganizationList(jshOrganization);
    }

    /**
     * 新增机构
     * 
     * @param jshOrganization 机构
     * @return 结果
     */
    @Override
    public int insertJshOrganization(JshOrganization jshOrganization)
    {
        jshOrganization.setCreateTime(DateUtils.getNowDate());
        return jshOrganizationMapper.insertJshOrganization(jshOrganization);
    }

    /**
     * 修改机构
     * 
     * @param jshOrganization 机构
     * @return 结果
     */
    @Override
    public int updateJshOrganization(JshOrganization jshOrganization)
    {
        jshOrganization.setUpdateTime(DateUtils.getNowDate());
        return jshOrganizationMapper.updateJshOrganization(jshOrganization);
    }

    /**
     * 批量删除机构
     * 
     * @param ids 需要删除的机构主键
     * @return 结果
     */
    @Override
    public int deleteJshOrganizationByIds(Long[] ids)
    {
        return jshOrganizationMapper.deleteJshOrganizationByIds(ids);
    }

    /**
     * 删除机构信息
     * 
     * @param id 机构主键
     * @return 结果
     */
    @Override
    public int deleteJshOrganizationById(Long id)
    {
        return jshOrganizationMapper.deleteJshOrganizationById(id);
    }
}
