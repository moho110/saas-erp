package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialInitialStockMapper;
import com.vrmlstudio.erp.domain.JshMaterialInitialStock;
import com.vrmlstudio.erp.service.IJshMaterialInitialStockService;

/**
 * 产品初始库存Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialInitialStockServiceImpl implements IJshMaterialInitialStockService 
{
    @Autowired
    private JshMaterialInitialStockMapper jshMaterialInitialStockMapper;

    /**
     * 查询产品初始库存
     * 
     * @param id 产品初始库存主键
     * @return 产品初始库存
     */
    @Override
    public JshMaterialInitialStock selectJshMaterialInitialStockById(Long id)
    {
        return jshMaterialInitialStockMapper.selectJshMaterialInitialStockById(id);
    }

    /**
     * 查询产品初始库存列表
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 产品初始库存
     */
    @Override
    public List<JshMaterialInitialStock> selectJshMaterialInitialStockList(JshMaterialInitialStock jshMaterialInitialStock)
    {
        return jshMaterialInitialStockMapper.selectJshMaterialInitialStockList(jshMaterialInitialStock);
    }

    /**
     * 新增产品初始库存
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 结果
     */
    @Override
    public int insertJshMaterialInitialStock(JshMaterialInitialStock jshMaterialInitialStock)
    {
        return jshMaterialInitialStockMapper.insertJshMaterialInitialStock(jshMaterialInitialStock);
    }

    /**
     * 修改产品初始库存
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 结果
     */
    @Override
    public int updateJshMaterialInitialStock(JshMaterialInitialStock jshMaterialInitialStock)
    {
        return jshMaterialInitialStockMapper.updateJshMaterialInitialStock(jshMaterialInitialStock);
    }

    /**
     * 批量删除产品初始库存
     * 
     * @param ids 需要删除的产品初始库存主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialInitialStockByIds(Long[] ids)
    {
        return jshMaterialInitialStockMapper.deleteJshMaterialInitialStockByIds(ids);
    }

    /**
     * 删除产品初始库存信息
     * 
     * @param id 产品初始库存主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialInitialStockById(Long id)
    {
        return jshMaterialInitialStockMapper.deleteJshMaterialInitialStockById(id);
    }
}
