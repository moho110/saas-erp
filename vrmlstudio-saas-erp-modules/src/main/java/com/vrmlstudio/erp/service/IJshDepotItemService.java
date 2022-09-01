package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshDepotItem;

/**
 * 单据子Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshDepotItemService 
{
    /**
     * 查询单据子
     * 
     * @param id 单据子主键
     * @return 单据子
     */
    public JshDepotItem selectJshDepotItemById(Long id);

    /**
     * 查询单据子列表
     * 
     * @param jshDepotItem 单据子
     * @return 单据子集合
     */
    public List<JshDepotItem> selectJshDepotItemList(JshDepotItem jshDepotItem);

    /**
     * 新增单据子
     * 
     * @param jshDepotItem 单据子
     * @return 结果
     */
    public int insertJshDepotItem(JshDepotItem jshDepotItem);

    /**
     * 修改单据子
     * 
     * @param jshDepotItem 单据子
     * @return 结果
     */
    public int updateJshDepotItem(JshDepotItem jshDepotItem);

    /**
     * 批量删除单据子
     * 
     * @param ids 需要删除的单据子主键集合
     * @return 结果
     */
    public int deleteJshDepotItemByIds(Long[] ids);

    /**
     * 删除单据子信息
     * 
     * @param id 单据子主键
     * @return 结果
     */
    public int deleteJshDepotItemById(Long id);
}
