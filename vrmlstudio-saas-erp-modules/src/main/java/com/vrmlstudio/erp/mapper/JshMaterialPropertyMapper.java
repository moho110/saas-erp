package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialProperty;

/**
 * 产品扩展字段Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshMaterialPropertyMapper 
{
    /**
     * 查询产品扩展字段
     * 
     * @param id 产品扩展字段主键
     * @return 产品扩展字段
     */
    public JshMaterialProperty selectJshMaterialPropertyById(Long id);

    /**
     * 查询产品扩展字段列表
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 产品扩展字段集合
     */
    public List<JshMaterialProperty> selectJshMaterialPropertyList(JshMaterialProperty jshMaterialProperty);

    /**
     * 新增产品扩展字段
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 结果
     */
    public int insertJshMaterialProperty(JshMaterialProperty jshMaterialProperty);

    /**
     * 修改产品扩展字段
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 结果
     */
    public int updateJshMaterialProperty(JshMaterialProperty jshMaterialProperty);

    /**
     * 删除产品扩展字段
     * 
     * @param id 产品扩展字段主键
     * @return 结果
     */
    public int deleteJshMaterialPropertyById(Long id);

    /**
     * 批量删除产品扩展字段
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshMaterialPropertyByIds(Long[] ids);
}
