package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshPlatformConfigMapper;
import com.vrmlstudio.erp.domain.JshPlatformConfig;
import com.vrmlstudio.erp.service.IJshPlatformConfigService;

/**
 * 平台参数Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshPlatformConfigServiceImpl implements IJshPlatformConfigService 
{
    @Autowired
    private JshPlatformConfigMapper jshPlatformConfigMapper;

    /**
     * 查询平台参数
     * 
     * @param id 平台参数主键
     * @return 平台参数
     */
    @Override
    public JshPlatformConfig selectJshPlatformConfigById(Long id)
    {
        return jshPlatformConfigMapper.selectJshPlatformConfigById(id);
    }

    /**
     * 查询平台参数列表
     * 
     * @param jshPlatformConfig 平台参数
     * @return 平台参数
     */
    @Override
    public List<JshPlatformConfig> selectJshPlatformConfigList(JshPlatformConfig jshPlatformConfig)
    {
        return jshPlatformConfigMapper.selectJshPlatformConfigList(jshPlatformConfig);
    }

    /**
     * 新增平台参数
     * 
     * @param jshPlatformConfig 平台参数
     * @return 结果
     */
    @Override
    public int insertJshPlatformConfig(JshPlatformConfig jshPlatformConfig)
    {
        return jshPlatformConfigMapper.insertJshPlatformConfig(jshPlatformConfig);
    }

    /**
     * 修改平台参数
     * 
     * @param jshPlatformConfig 平台参数
     * @return 结果
     */
    @Override
    public int updateJshPlatformConfig(JshPlatformConfig jshPlatformConfig)
    {
        return jshPlatformConfigMapper.updateJshPlatformConfig(jshPlatformConfig);
    }

    /**
     * 批量删除平台参数
     * 
     * @param ids 需要删除的平台参数主键
     * @return 结果
     */
    @Override
    public int deleteJshPlatformConfigByIds(Long[] ids)
    {
        return jshPlatformConfigMapper.deleteJshPlatformConfigByIds(ids);
    }

    /**
     * 删除平台参数信息
     * 
     * @param id 平台参数主键
     * @return 结果
     */
    @Override
    public int deleteJshPlatformConfigById(Long id)
    {
        return jshPlatformConfigMapper.deleteJshPlatformConfigById(id);
    }
}
