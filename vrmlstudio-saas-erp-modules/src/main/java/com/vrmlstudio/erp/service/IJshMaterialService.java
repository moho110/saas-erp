package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterial;

/**
 * 产品Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshMaterialService 
{
    /**
     * 查询产品
     * 
     * @param id 产品主键
     * @return 产品
     */
    public JshMaterial selectJshMaterialById(Long id);

    /**
     * 查询产品列表
     * 
     * @param jshMaterial 产品
     * @return 产品集合
     */
    public List<JshMaterial> selectJshMaterialList(JshMaterial jshMaterial);

    /**
     * 新增产品
     * 
     * @param jshMaterial 产品
     * @return 结果
     */
    public int insertJshMaterial(JshMaterial jshMaterial);

    /**
     * 修改产品
     * 
     * @param jshMaterial 产品
     * @return 结果
     */
    public int updateJshMaterial(JshMaterial jshMaterial);

    /**
     * 批量删除产品
     * 
     * @param ids 需要删除的产品主键集合
     * @return 结果
     */
    public int deleteJshMaterialByIds(Long[] ids);

    /**
     * 删除产品信息
     * 
     * @param id 产品主键
     * @return 结果
     */
    public int deleteJshMaterialById(Long id);
}
