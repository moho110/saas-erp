package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshAccountItem;

/**
 * 财务子Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshAccountItemService 
{
    /**
     * 查询财务子
     * 
     * @param id 财务子主键
     * @return 财务子
     */
    public JshAccountItem selectJshAccountItemById(Long id);

    /**
     * 查询财务子列表
     * 
     * @param jshAccountItem 财务子
     * @return 财务子集合
     */
    public List<JshAccountItem> selectJshAccountItemList(JshAccountItem jshAccountItem);

    /**
     * 新增财务子
     * 
     * @param jshAccountItem 财务子
     * @return 结果
     */
    public int insertJshAccountItem(JshAccountItem jshAccountItem);

    /**
     * 修改财务子
     * 
     * @param jshAccountItem 财务子
     * @return 结果
     */
    public int updateJshAccountItem(JshAccountItem jshAccountItem);

    /**
     * 批量删除财务子
     * 
     * @param ids 需要删除的财务子主键集合
     * @return 结果
     */
    public int deleteJshAccountItemByIds(Long[] ids);

    /**
     * 删除财务子信息
     * 
     * @param id 财务子主键
     * @return 结果
     */
    public int deleteJshAccountItemById(Long id);
}
