package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialPropertyMapper;
import com.vrmlstudio.erp.domain.JshMaterialProperty;
import com.vrmlstudio.erp.service.IJshMaterialPropertyService;

/**
 * 产品扩展字段Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialPropertyServiceImpl implements IJshMaterialPropertyService 
{
    @Autowired
    private JshMaterialPropertyMapper jshMaterialPropertyMapper;

    /**
     * 查询产品扩展字段
     * 
     * @param id 产品扩展字段主键
     * @return 产品扩展字段
     */
    @Override
    public JshMaterialProperty selectJshMaterialPropertyById(Long id)
    {
        return jshMaterialPropertyMapper.selectJshMaterialPropertyById(id);
    }

    /**
     * 查询产品扩展字段列表
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 产品扩展字段
     */
    @Override
    public List<JshMaterialProperty> selectJshMaterialPropertyList(JshMaterialProperty jshMaterialProperty)
    {
        return jshMaterialPropertyMapper.selectJshMaterialPropertyList(jshMaterialProperty);
    }

    /**
     * 新增产品扩展字段
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 结果
     */
    @Override
    public int insertJshMaterialProperty(JshMaterialProperty jshMaterialProperty)
    {
        return jshMaterialPropertyMapper.insertJshMaterialProperty(jshMaterialProperty);
    }

    /**
     * 修改产品扩展字段
     * 
     * @param jshMaterialProperty 产品扩展字段
     * @return 结果
     */
    @Override
    public int updateJshMaterialProperty(JshMaterialProperty jshMaterialProperty)
    {
        return jshMaterialPropertyMapper.updateJshMaterialProperty(jshMaterialProperty);
    }

    /**
     * 批量删除产品扩展字段
     * 
     * @param ids 需要删除的产品扩展字段主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialPropertyByIds(Long[] ids)
    {
        return jshMaterialPropertyMapper.deleteJshMaterialPropertyByIds(ids);
    }

    /**
     * 删除产品扩展字段信息
     * 
     * @param id 产品扩展字段主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialPropertyById(Long id)
    {
        return jshMaterialPropertyMapper.deleteJshMaterialPropertyById(id);
    }
}
