package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshDepotItemMapper;
import com.vrmlstudio.erp.domain.JshDepotItem;
import com.vrmlstudio.erp.service.IJshDepotItemService;

/**
 * 单据子Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshDepotItemServiceImpl implements IJshDepotItemService 
{
    @Autowired
    private JshDepotItemMapper jshDepotItemMapper;

    /**
     * 查询单据子
     * 
     * @param id 单据子主键
     * @return 单据子
     */
    @Override
    public JshDepotItem selectJshDepotItemById(Long id)
    {
        return jshDepotItemMapper.selectJshDepotItemById(id);
    }

    /**
     * 查询单据子列表
     * 
     * @param jshDepotItem 单据子
     * @return 单据子
     */
    @Override
    public List<JshDepotItem> selectJshDepotItemList(JshDepotItem jshDepotItem)
    {
        return jshDepotItemMapper.selectJshDepotItemList(jshDepotItem);
    }

    /**
     * 新增单据子
     * 
     * @param jshDepotItem 单据子
     * @return 结果
     */
    @Override
    public int insertJshDepotItem(JshDepotItem jshDepotItem)
    {
        return jshDepotItemMapper.insertJshDepotItem(jshDepotItem);
    }

    /**
     * 修改单据子
     * 
     * @param jshDepotItem 单据子
     * @return 结果
     */
    @Override
    public int updateJshDepotItem(JshDepotItem jshDepotItem)
    {
        return jshDepotItemMapper.updateJshDepotItem(jshDepotItem);
    }

    /**
     * 批量删除单据子
     * 
     * @param ids 需要删除的单据子主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotItemByIds(Long[] ids)
    {
        return jshDepotItemMapper.deleteJshDepotItemByIds(ids);
    }

    /**
     * 删除单据子信息
     * 
     * @param id 单据子主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotItemById(Long id)
    {
        return jshDepotItemMapper.deleteJshDepotItemById(id);
    }
}
