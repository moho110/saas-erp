package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialAttributeMapper;
import com.vrmlstudio.erp.domain.JshMaterialAttribute;
import com.vrmlstudio.erp.service.IJshMaterialAttributeService;

/**
 * 产品属性Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialAttributeServiceImpl implements IJshMaterialAttributeService 
{
    @Autowired
    private JshMaterialAttributeMapper jshMaterialAttributeMapper;

    /**
     * 查询产品属性
     * 
     * @param id 产品属性主键
     * @return 产品属性
     */
    @Override
    public JshMaterialAttribute selectJshMaterialAttributeById(Long id)
    {
        return jshMaterialAttributeMapper.selectJshMaterialAttributeById(id);
    }

    /**
     * 查询产品属性列表
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 产品属性
     */
    @Override
    public List<JshMaterialAttribute> selectJshMaterialAttributeList(JshMaterialAttribute jshMaterialAttribute)
    {
        return jshMaterialAttributeMapper.selectJshMaterialAttributeList(jshMaterialAttribute);
    }

    /**
     * 新增产品属性
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 结果
     */
    @Override
    public int insertJshMaterialAttribute(JshMaterialAttribute jshMaterialAttribute)
    {
        return jshMaterialAttributeMapper.insertJshMaterialAttribute(jshMaterialAttribute);
    }

    /**
     * 修改产品属性
     * 
     * @param jshMaterialAttribute 产品属性
     * @return 结果
     */
    @Override
    public int updateJshMaterialAttribute(JshMaterialAttribute jshMaterialAttribute)
    {
        return jshMaterialAttributeMapper.updateJshMaterialAttribute(jshMaterialAttribute);
    }

    /**
     * 批量删除产品属性
     * 
     * @param ids 需要删除的产品属性主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialAttributeByIds(Long[] ids)
    {
        return jshMaterialAttributeMapper.deleteJshMaterialAttributeByIds(ids);
    }

    /**
     * 删除产品属性信息
     * 
     * @param id 产品属性主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialAttributeById(Long id)
    {
        return jshMaterialAttributeMapper.deleteJshMaterialAttributeById(id);
    }
}
