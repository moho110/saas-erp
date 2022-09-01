package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshUnit;

/**
 * 多单位Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshUnitService 
{
    /**
     * 查询多单位
     * 
     * @param id 多单位主键
     * @return 多单位
     */
    public JshUnit selectJshUnitById(Long id);

    /**
     * 查询多单位列表
     * 
     * @param jshUnit 多单位
     * @return 多单位集合
     */
    public List<JshUnit> selectJshUnitList(JshUnit jshUnit);

    /**
     * 新增多单位
     * 
     * @param jshUnit 多单位
     * @return 结果
     */
    public int insertJshUnit(JshUnit jshUnit);

    /**
     * 修改多单位
     * 
     * @param jshUnit 多单位
     * @return 结果
     */
    public int updateJshUnit(JshUnit jshUnit);

    /**
     * 批量删除多单位
     * 
     * @param ids 需要删除的多单位主键集合
     * @return 结果
     */
    public int deleteJshUnitByIds(Long[] ids);

    /**
     * 删除多单位信息
     * 
     * @param id 多单位主键
     * @return 结果
     */
    public int deleteJshUnitById(Long id);
}
