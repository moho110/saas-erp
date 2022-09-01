package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshFunction;

/**
 * 功能模块Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshFunctionService 
{
    /**
     * 查询功能模块
     * 
     * @param id 功能模块主键
     * @return 功能模块
     */
    public JshFunction selectJshFunctionById(Long id);

    /**
     * 查询功能模块列表
     * 
     * @param jshFunction 功能模块
     * @return 功能模块集合
     */
    public List<JshFunction> selectJshFunctionList(JshFunction jshFunction);

    /**
     * 新增功能模块
     * 
     * @param jshFunction 功能模块
     * @return 结果
     */
    public int insertJshFunction(JshFunction jshFunction);

    /**
     * 修改功能模块
     * 
     * @param jshFunction 功能模块
     * @return 结果
     */
    public int updateJshFunction(JshFunction jshFunction);

    /**
     * 批量删除功能模块
     * 
     * @param ids 需要删除的功能模块主键集合
     * @return 结果
     */
    public int deleteJshFunctionByIds(Long[] ids);

    /**
     * 删除功能模块信息
     * 
     * @param id 功能模块主键
     * @return 结果
     */
    public int deleteJshFunctionById(Long id);
}
