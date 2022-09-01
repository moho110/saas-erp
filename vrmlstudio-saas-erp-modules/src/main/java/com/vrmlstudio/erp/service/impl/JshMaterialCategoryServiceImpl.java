package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialCategoryMapper;
import com.vrmlstudio.erp.domain.JshMaterialCategory;
import com.vrmlstudio.erp.service.IJshMaterialCategoryService;

/**
 * 产品类型Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialCategoryServiceImpl implements IJshMaterialCategoryService 
{
    @Autowired
    private JshMaterialCategoryMapper jshMaterialCategoryMapper;

    /**
     * 查询产品类型
     * 
     * @param id 产品类型主键
     * @return 产品类型
     */
    @Override
    public JshMaterialCategory selectJshMaterialCategoryById(Long id)
    {
        return jshMaterialCategoryMapper.selectJshMaterialCategoryById(id);
    }

    /**
     * 查询产品类型列表
     * 
     * @param jshMaterialCategory 产品类型
     * @return 产品类型
     */
    @Override
    public List<JshMaterialCategory> selectJshMaterialCategoryList(JshMaterialCategory jshMaterialCategory)
    {
        return jshMaterialCategoryMapper.selectJshMaterialCategoryList(jshMaterialCategory);
    }

    /**
     * 新增产品类型
     * 
     * @param jshMaterialCategory 产品类型
     * @return 结果
     */
    @Override
    public int insertJshMaterialCategory(JshMaterialCategory jshMaterialCategory)
    {
        jshMaterialCategory.setCreateTime(DateUtils.getNowDate());
        return jshMaterialCategoryMapper.insertJshMaterialCategory(jshMaterialCategory);
    }

    /**
     * 修改产品类型
     * 
     * @param jshMaterialCategory 产品类型
     * @return 结果
     */
    @Override
    public int updateJshMaterialCategory(JshMaterialCategory jshMaterialCategory)
    {
        jshMaterialCategory.setUpdateTime(DateUtils.getNowDate());
        return jshMaterialCategoryMapper.updateJshMaterialCategory(jshMaterialCategory);
    }

    /**
     * 批量删除产品类型
     * 
     * @param ids 需要删除的产品类型主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialCategoryByIds(Long[] ids)
    {
        return jshMaterialCategoryMapper.deleteJshMaterialCategoryByIds(ids);
    }

    /**
     * 删除产品类型信息
     * 
     * @param id 产品类型主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialCategoryById(Long id)
    {
        return jshMaterialCategoryMapper.deleteJshMaterialCategoryById(id);
    }
}
