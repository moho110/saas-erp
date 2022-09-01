package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshSystemConfigMapper;
import com.vrmlstudio.erp.domain.JshSystemConfig;
import com.vrmlstudio.erp.service.IJshSystemConfigService;

/**
 * 系统参数Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshSystemConfigServiceImpl implements IJshSystemConfigService 
{
    @Autowired
    private JshSystemConfigMapper jshSystemConfigMapper;

    /**
     * 查询系统参数
     * 
     * @param id 系统参数主键
     * @return 系统参数
     */
    @Override
    public JshSystemConfig selectJshSystemConfigById(Long id)
    {
        return jshSystemConfigMapper.selectJshSystemConfigById(id);
    }

    /**
     * 查询系统参数列表
     * 
     * @param jshSystemConfig 系统参数
     * @return 系统参数
     */
    @Override
    public List<JshSystemConfig> selectJshSystemConfigList(JshSystemConfig jshSystemConfig)
    {
        return jshSystemConfigMapper.selectJshSystemConfigList(jshSystemConfig);
    }

    /**
     * 新增系统参数
     * 
     * @param jshSystemConfig 系统参数
     * @return 结果
     */
    @Override
    public int insertJshSystemConfig(JshSystemConfig jshSystemConfig)
    {
        return jshSystemConfigMapper.insertJshSystemConfig(jshSystemConfig);
    }

    /**
     * 修改系统参数
     * 
     * @param jshSystemConfig 系统参数
     * @return 结果
     */
    @Override
    public int updateJshSystemConfig(JshSystemConfig jshSystemConfig)
    {
        return jshSystemConfigMapper.updateJshSystemConfig(jshSystemConfig);
    }

    /**
     * 批量删除系统参数
     * 
     * @param ids 需要删除的系统参数主键
     * @return 结果
     */
    @Override
    public int deleteJshSystemConfigByIds(Long[] ids)
    {
        return jshSystemConfigMapper.deleteJshSystemConfigByIds(ids);
    }

    /**
     * 删除系统参数信息
     * 
     * @param id 系统参数主键
     * @return 结果
     */
    @Override
    public int deleteJshSystemConfigById(Long id)
    {
        return jshSystemConfigMapper.deleteJshSystemConfigById(id);
    }
}
