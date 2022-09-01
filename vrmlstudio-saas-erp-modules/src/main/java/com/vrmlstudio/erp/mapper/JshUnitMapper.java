package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshUnit;

/**
 * 多单位Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshUnitMapper 
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
     * 删除多单位
     * 
     * @param id 多单位主键
     * @return 结果
     */
    public int deleteJshUnitById(Long id);

    /**
     * 批量删除多单位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshUnitByIds(Long[] ids);
}
