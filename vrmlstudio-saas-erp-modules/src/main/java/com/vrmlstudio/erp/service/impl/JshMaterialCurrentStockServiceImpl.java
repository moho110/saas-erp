package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialCurrentStockMapper;
import com.vrmlstudio.erp.domain.JshMaterialCurrentStock;
import com.vrmlstudio.erp.service.IJshMaterialCurrentStockService;

/**
 * 产品当前库存Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialCurrentStockServiceImpl implements IJshMaterialCurrentStockService 
{
    @Autowired
    private JshMaterialCurrentStockMapper jshMaterialCurrentStockMapper;

    /**
     * 查询产品当前库存
     * 
     * @param id 产品当前库存主键
     * @return 产品当前库存
     */
    @Override
    public JshMaterialCurrentStock selectJshMaterialCurrentStockById(Long id)
    {
        return jshMaterialCurrentStockMapper.selectJshMaterialCurrentStockById(id);
    }

    /**
     * 查询产品当前库存列表
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 产品当前库存
     */
    @Override
    public List<JshMaterialCurrentStock> selectJshMaterialCurrentStockList(JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        return jshMaterialCurrentStockMapper.selectJshMaterialCurrentStockList(jshMaterialCurrentStock);
    }

    /**
     * 新增产品当前库存
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 结果
     */
    @Override
    public int insertJshMaterialCurrentStock(JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        return jshMaterialCurrentStockMapper.insertJshMaterialCurrentStock(jshMaterialCurrentStock);
    }

    /**
     * 修改产品当前库存
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 结果
     */
    @Override
    public int updateJshMaterialCurrentStock(JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        return jshMaterialCurrentStockMapper.updateJshMaterialCurrentStock(jshMaterialCurrentStock);
    }

    /**
     * 批量删除产品当前库存
     * 
     * @param ids 需要删除的产品当前库存主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialCurrentStockByIds(Long[] ids)
    {
        return jshMaterialCurrentStockMapper.deleteJshMaterialCurrentStockByIds(ids);
    }

    /**
     * 删除产品当前库存信息
     * 
     * @param id 产品当前库存主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialCurrentStockById(Long id)
    {
        return jshMaterialCurrentStockMapper.deleteJshMaterialCurrentStockById(id);
    }
}
