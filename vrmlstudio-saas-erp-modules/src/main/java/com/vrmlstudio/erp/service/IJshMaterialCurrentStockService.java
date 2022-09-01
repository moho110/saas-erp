package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialCurrentStock;

/**
 * 产品当前库存Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshMaterialCurrentStockService 
{
    /**
     * 查询产品当前库存
     * 
     * @param id 产品当前库存主键
     * @return 产品当前库存
     */
    public JshMaterialCurrentStock selectJshMaterialCurrentStockById(Long id);

    /**
     * 查询产品当前库存列表
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 产品当前库存集合
     */
    public List<JshMaterialCurrentStock> selectJshMaterialCurrentStockList(JshMaterialCurrentStock jshMaterialCurrentStock);

    /**
     * 新增产品当前库存
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 结果
     */
    public int insertJshMaterialCurrentStock(JshMaterialCurrentStock jshMaterialCurrentStock);

    /**
     * 修改产品当前库存
     * 
     * @param jshMaterialCurrentStock 产品当前库存
     * @return 结果
     */
    public int updateJshMaterialCurrentStock(JshMaterialCurrentStock jshMaterialCurrentStock);

    /**
     * 批量删除产品当前库存
     * 
     * @param ids 需要删除的产品当前库存主键集合
     * @return 结果
     */
    public int deleteJshMaterialCurrentStockByIds(Long[] ids);

    /**
     * 删除产品当前库存信息
     * 
     * @param id 产品当前库存主键
     * @return 结果
     */
    public int deleteJshMaterialCurrentStockById(Long id);
}
