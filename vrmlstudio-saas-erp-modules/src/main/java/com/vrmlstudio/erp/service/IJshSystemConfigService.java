package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshSystemConfig;

/**
 * 系统参数Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshSystemConfigService 
{
    /**
     * 查询系统参数
     * 
     * @param id 系统参数主键
     * @return 系统参数
     */
    public JshSystemConfig selectJshSystemConfigById(Long id);

    /**
     * 查询系统参数列表
     * 
     * @param jshSystemConfig 系统参数
     * @return 系统参数集合
     */
    public List<JshSystemConfig> selectJshSystemConfigList(JshSystemConfig jshSystemConfig);

    /**
     * 新增系统参数
     * 
     * @param jshSystemConfig 系统参数
     * @return 结果
     */
    public int insertJshSystemConfig(JshSystemConfig jshSystemConfig);

    /**
     * 修改系统参数
     * 
     * @param jshSystemConfig 系统参数
     * @return 结果
     */
    public int updateJshSystemConfig(JshSystemConfig jshSystemConfig);

    /**
     * 批量删除系统参数
     * 
     * @param ids 需要删除的系统参数主键集合
     * @return 结果
     */
    public int deleteJshSystemConfigByIds(Long[] ids);

    /**
     * 删除系统参数信息
     * 
     * @param id 系统参数主键
     * @return 结果
     */
    public int deleteJshSystemConfigById(Long id);
}
