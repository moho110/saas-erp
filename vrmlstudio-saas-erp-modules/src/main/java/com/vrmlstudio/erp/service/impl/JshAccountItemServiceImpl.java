package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshAccountItemMapper;
import com.vrmlstudio.erp.domain.JshAccountItem;
import com.vrmlstudio.erp.service.IJshAccountItemService;

/**
 * 财务子Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshAccountItemServiceImpl implements IJshAccountItemService 
{
    @Autowired
    private JshAccountItemMapper jshAccountItemMapper;

    /**
     * 查询财务子
     * 
     * @param id 财务子主键
     * @return 财务子
     */
    @Override
    public JshAccountItem selectJshAccountItemById(Long id)
    {
        return jshAccountItemMapper.selectJshAccountItemById(id);
    }

    /**
     * 查询财务子列表
     * 
     * @param jshAccountItem 财务子
     * @return 财务子
     */
    @Override
    public List<JshAccountItem> selectJshAccountItemList(JshAccountItem jshAccountItem)
    {
        return jshAccountItemMapper.selectJshAccountItemList(jshAccountItem);
    }

    /**
     * 新增财务子
     * 
     * @param jshAccountItem 财务子
     * @return 结果
     */
    @Override
    public int insertJshAccountItem(JshAccountItem jshAccountItem)
    {
        return jshAccountItemMapper.insertJshAccountItem(jshAccountItem);
    }

    /**
     * 修改财务子
     * 
     * @param jshAccountItem 财务子
     * @return 结果
     */
    @Override
    public int updateJshAccountItem(JshAccountItem jshAccountItem)
    {
        return jshAccountItemMapper.updateJshAccountItem(jshAccountItem);
    }

    /**
     * 批量删除财务子
     * 
     * @param ids 需要删除的财务子主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountItemByIds(Long[] ids)
    {
        return jshAccountItemMapper.deleteJshAccountItemByIds(ids);
    }

    /**
     * 删除财务子信息
     * 
     * @param id 财务子主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountItemById(Long id)
    {
        return jshAccountItemMapper.deleteJshAccountItemById(id);
    }
}
