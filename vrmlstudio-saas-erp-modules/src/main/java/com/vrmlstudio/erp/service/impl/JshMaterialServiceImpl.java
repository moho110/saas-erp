package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialMapper;
import com.vrmlstudio.erp.domain.JshMaterial;
import com.vrmlstudio.erp.service.IJshMaterialService;

/**
 * 产品Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialServiceImpl implements IJshMaterialService 
{
    @Autowired
    private JshMaterialMapper jshMaterialMapper;

    /**
     * 查询产品
     * 
     * @param id 产品主键
     * @return 产品
     */
    @Override
    public JshMaterial selectJshMaterialById(Long id)
    {
        return jshMaterialMapper.selectJshMaterialById(id);
    }

    /**
     * 查询产品列表
     * 
     * @param jshMaterial 产品
     * @return 产品
     */
    @Override
    public List<JshMaterial> selectJshMaterialList(JshMaterial jshMaterial)
    {
        return jshMaterialMapper.selectJshMaterialList(jshMaterial);
    }

    /**
     * 新增产品
     * 
     * @param jshMaterial 产品
     * @return 结果
     */
    @Override
    public int insertJshMaterial(JshMaterial jshMaterial)
    {
        return jshMaterialMapper.insertJshMaterial(jshMaterial);
    }

    /**
     * 修改产品
     * 
     * @param jshMaterial 产品
     * @return 结果
     */
    @Override
    public int updateJshMaterial(JshMaterial jshMaterial)
    {
        return jshMaterialMapper.updateJshMaterial(jshMaterial);
    }

    /**
     * 批量删除产品
     * 
     * @param ids 需要删除的产品主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialByIds(Long[] ids)
    {
        return jshMaterialMapper.deleteJshMaterialByIds(ids);
    }

    /**
     * 删除产品信息
     * 
     * @param id 产品主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialById(Long id)
    {
        return jshMaterialMapper.deleteJshMaterialById(id);
    }
}
