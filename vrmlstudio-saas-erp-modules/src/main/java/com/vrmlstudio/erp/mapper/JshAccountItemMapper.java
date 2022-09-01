package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshAccountItem;

/**
 * 财务子Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshAccountItemMapper 
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
     * 删除财务子
     * 
     * @param id 财务子主键
     * @return 结果
     */
    public int deleteJshAccountItemById(Long id);

    /**
     * 批量删除财务子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshAccountItemByIds(Long[] ids);
}
