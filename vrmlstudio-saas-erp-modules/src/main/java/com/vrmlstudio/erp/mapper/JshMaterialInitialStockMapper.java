package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialInitialStock;

/**
 * 产品初始库存Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshMaterialInitialStockMapper 
{
    /**
     * 查询产品初始库存
     * 
     * @param id 产品初始库存主键
     * @return 产品初始库存
     */
    public JshMaterialInitialStock selectJshMaterialInitialStockById(Long id);

    /**
     * 查询产品初始库存列表
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 产品初始库存集合
     */
    public List<JshMaterialInitialStock> selectJshMaterialInitialStockList(JshMaterialInitialStock jshMaterialInitialStock);

    /**
     * 新增产品初始库存
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 结果
     */
    public int insertJshMaterialInitialStock(JshMaterialInitialStock jshMaterialInitialStock);

    /**
     * 修改产品初始库存
     * 
     * @param jshMaterialInitialStock 产品初始库存
     * @return 结果
     */
    public int updateJshMaterialInitialStock(JshMaterialInitialStock jshMaterialInitialStock);

    /**
     * 删除产品初始库存
     * 
     * @param id 产品初始库存主键
     * @return 结果
     */
    public int deleteJshMaterialInitialStockById(Long id);

    /**
     * 批量删除产品初始库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshMaterialInitialStockByIds(Long[] ids);
}
