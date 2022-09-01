package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialAttribute;

/**
 * 产品属性Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshMaterialAttributeMapper 
{
    /**
     * 查询产品属性
     * 
     * @param id 产品属性主键
     * @return 产品属性
     */
    public JshMaterialAttribute selectJshMaterialAttributeById(Long id);

    /**
     * 查询产品属性列表
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 产品属性集合
     */
    public List<JshMaterialAttribute> selectJshMaterialAttributeList(JshMaterialAttribute jshMaterialAttribute);

    /**
     * 新增产品属性
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 结果
     */
    public int insertJshMaterialAttribute(JshMaterialAttribute jshMaterialAttribute);

    /**
     * 修改产品属性
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 结果
     */
    public int updateJshMaterialAttribute(JshMaterialAttribute jshMaterialAttribute);

    /**
     * 删除产品属性
     * 
     * @param id 产品属性主键
     * @return 结果
     */
    public int deleteJshMaterialAttributeById(Long id);

    /**
     * 批量删除产品属性
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshMaterialAttributeByIds(Long[] ids);
}
