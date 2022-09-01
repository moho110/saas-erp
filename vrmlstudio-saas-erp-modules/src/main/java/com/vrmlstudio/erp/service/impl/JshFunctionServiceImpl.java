package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshFunctionMapper;
import com.vrmlstudio.erp.domain.JshFunction;
import com.vrmlstudio.erp.service.IJshFunctionService;

/**
 * 功能模块Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshFunctionServiceImpl implements IJshFunctionService 
{
    @Autowired
    private JshFunctionMapper jshFunctionMapper;

    /**
     * 查询功能模块
     * 
     * @param id 功能模块主键
     * @return 功能模块
     */
    @Override
    public JshFunction selectJshFunctionById(Long id)
    {
        return jshFunctionMapper.selectJshFunctionById(id);
    }

    /**
     * 查询功能模块列表
     * 
     * @param jshFunction 功能模块
     * @return 功能模块
     */
    @Override
    public List<JshFunction> selectJshFunctionList(JshFunction jshFunction)
    {
        return jshFunctionMapper.selectJshFunctionList(jshFunction);
    }

    /**
     * 新增功能模块
     * 
     * @param jshFunction 功能模块
     * @return 结果
     */
    @Override
    public int insertJshFunction(JshFunction jshFunction)
    {
        return jshFunctionMapper.insertJshFunction(jshFunction);
    }

    /**
     * 修改功能模块
     * 
     * @param jshFunction 功能模块
     * @return 结果
     */
    @Override
    public int updateJshFunction(JshFunction jshFunction)
    {
        return jshFunctionMapper.updateJshFunction(jshFunction);
    }

    /**
     * 批量删除功能模块
     * 
     * @param ids 需要删除的功能模块主键
     * @return 结果
     */
    @Override
    public int deleteJshFunctionByIds(Long[] ids)
    {
        return jshFunctionMapper.deleteJshFunctionByIds(ids);
    }

    /**
     * 删除功能模块信息
     * 
     * @param id 功能模块主键
     * @return 结果
     */
    @Override
    public int deleteJshFunctionById(Long id)
    {
        return jshFunctionMapper.deleteJshFunctionById(id);
    }
}
