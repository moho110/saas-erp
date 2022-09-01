package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialCategory;

/**
 * 产品类型Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshMaterialCategoryService 
{
    /**
     * 查询产品类型
     * 
     * @param id 产品类型主键
     * @return 产品类型
     */
    public JshMaterialCategory selectJshMaterialCategoryById(Long id);

    /**
     * 查询产品类型列表
     * 
     * @param jshMaterialCategory 产品类型
     * @return 产品类型集合
     */
    public List<JshMaterialCategory> selectJshMaterialCategoryList(JshMaterialCategory jshMaterialCategory);

    /**
     * 新增产品类型
     * 
     * @param jshMaterialCategory 产品类型
     * @return 结果
     */
    public int insertJshMaterialCategory(JshMaterialCategory jshMaterialCategory);

    /**
     * 修改产品类型
     * 
     * @param jshMaterialCategory 产品类型
     * @return 结果
     */
    public int updateJshMaterialCategory(JshMaterialCategory jshMaterialCategory);

    /**
     * 批量删除产品类型
     * 
     * @param ids 需要删除的产品类型主键集合
     * @return 结果
     */
    public int deleteJshMaterialCategoryByIds(Long[] ids);

    /**
     * 删除产品类型信息
     * 
     * @param id 产品类型主键
     * @return 结果
     */
    public int deleteJshMaterialCategoryById(Long id);
}
