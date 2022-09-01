package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshPlatformConfig;

/**
 * 平台参数Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshPlatformConfigService 
{
    /**
     * 查询平台参数
     * 
     * @param id 平台参数主键
     * @return 平台参数
     */
    public JshPlatformConfig selectJshPlatformConfigById(Long id);

    /**
     * 查询平台参数列表
     * 
     * @param jshPlatformConfig 平台参数
     * @return 平台参数集合
     */
    public List<JshPlatformConfig> selectJshPlatformConfigList(JshPlatformConfig jshPlatformConfig);

    /**
     * 新增平台参数
     * 
     * @param jshPlatformConfig 平台参数
     * @return 结果
     */
    public int insertJshPlatformConfig(JshPlatformConfig jshPlatformConfig);

    /**
     * 修改平台参数
     * 
     * @param jshPlatformConfig 平台参数
     * @return 结果
     */
    public int updateJshPlatformConfig(JshPlatformConfig jshPlatformConfig);

    /**
     * 批量删除平台参数
     * 
     * @param ids 需要删除的平台参数主键集合
     * @return 结果
     */
    public int deleteJshPlatformConfigByIds(Long[] ids);

    /**
     * 删除平台参数信息
     * 
     * @param id 平台参数主键
     * @return 结果
     */
    public int deleteJshPlatformConfigById(Long id);
}
