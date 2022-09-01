package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshUnitMapper;
import com.vrmlstudio.erp.domain.JshUnit;
import com.vrmlstudio.erp.service.IJshUnitService;

/**
 * 多单位Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshUnitServiceImpl implements IJshUnitService 
{
    @Autowired
    private JshUnitMapper jshUnitMapper;

    /**
     * 查询多单位
     * 
     * @param id 多单位主键
     * @return 多单位
     */
    @Override
    public JshUnit selectJshUnitById(Long id)
    {
        return jshUnitMapper.selectJshUnitById(id);
    }

    /**
     * 查询多单位列表
     * 
     * @param jshUnit 多单位
     * @return 多单位
     */
    @Override
    public List<JshUnit> selectJshUnitList(JshUnit jshUnit)
    {
        return jshUnitMapper.selectJshUnitList(jshUnit);
    }

    /**
     * 新增多单位
     * 
     * @param jshUnit 多单位
     * @return 结果
     */
    @Override
    public int insertJshUnit(JshUnit jshUnit)
    {
        return jshUnitMapper.insertJshUnit(jshUnit);
    }

    /**
     * 修改多单位
     * 
     * @param jshUnit 多单位
     * @return 结果
     */
    @Override
    public int updateJshUnit(JshUnit jshUnit)
    {
        return jshUnitMapper.updateJshUnit(jshUnit);
    }

    /**
     * 批量删除多单位
     * 
     * @param ids 需要删除的多单位主键
     * @return 结果
     */
    @Override
    public int deleteJshUnitByIds(Long[] ids)
    {
        return jshUnitMapper.deleteJshUnitByIds(ids);
    }

    /**
     * 删除多单位信息
     * 
     * @param id 多单位主键
     * @return 结果
     */
    @Override
    public int deleteJshUnitById(Long id)
    {
        return jshUnitMapper.deleteJshUnitById(id);
    }
}
