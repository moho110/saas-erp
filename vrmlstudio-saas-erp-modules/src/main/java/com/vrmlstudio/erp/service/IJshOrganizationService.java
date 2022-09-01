package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshOrganization;

/**
 * 机构Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshOrganizationService 
{
    /**
     * 查询机构
     * 
     * @param id 机构主键
     * @return 机构
     */
    public JshOrganization selectJshOrganizationById(Long id);

    /**
     * 查询机构列表
     * 
     * @param jshOrganization 机构
     * @return 机构集合
     */
    public List<JshOrganization> selectJshOrganizationList(JshOrganization jshOrganization);

    /**
     * 新增机构
     * 
     * @param jshOrganization 机构
     * @return 结果
     */
    public int insertJshOrganization(JshOrganization jshOrganization);

    /**
     * 修改机构
     * 
     * @param jshOrganization 机构
     * @return 结果
     */
    public int updateJshOrganization(JshOrganization jshOrganization);

    /**
     * 批量删除机构
     * 
     * @param ids 需要删除的机构主键集合
     * @return 结果
     */
    public int deleteJshOrganizationByIds(Long[] ids);

    /**
     * 删除机构信息
     * 
     * @param id 机构主键
     * @return 结果
     */
    public int deleteJshOrganizationById(Long id);
}
