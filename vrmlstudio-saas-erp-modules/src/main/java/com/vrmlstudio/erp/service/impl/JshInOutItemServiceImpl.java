package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshInOutItemMapper;
import com.vrmlstudio.erp.domain.JshInOutItem;
import com.vrmlstudio.erp.service.IJshInOutItemService;

/**
 * 收支项目Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshInOutItemServiceImpl implements IJshInOutItemService 
{
    @Autowired
    private JshInOutItemMapper jshInOutItemMapper;

    /**
     * 查询收支项目
     * 
     * @param id 收支项目主键
     * @return 收支项目
     */
    @Override
    public JshInOutItem selectJshInOutItemById(Long id)
    {
        return jshInOutItemMapper.selectJshInOutItemById(id);
    }

    /**
     * 查询收支项目列表
     * 
     * @param jshInOutItem 收支项目
     * @return 收支项目
     */
    @Override
    public List<JshInOutItem> selectJshInOutItemList(JshInOutItem jshInOutItem)
    {
        return jshInOutItemMapper.selectJshInOutItemList(jshInOutItem);
    }

    /**
     * 新增收支项目
     * 
     * @param jshInOutItem 收支项目
     * @return 结果
     */
    @Override
    public int insertJshInOutItem(JshInOutItem jshInOutItem)
    {
        return jshInOutItemMapper.insertJshInOutItem(jshInOutItem);
    }

    /**
     * 修改收支项目
     * 
     * @param jshInOutItem 收支项目
     * @return 结果
     */
    @Override
    public int updateJshInOutItem(JshInOutItem jshInOutItem)
    {
        return jshInOutItemMapper.updateJshInOutItem(jshInOutItem);
    }

    /**
     * 批量删除收支项目
     * 
     * @param ids 需要删除的收支项目主键
     * @return 结果
     */
    @Override
    public int deleteJshInOutItemByIds(Long[] ids)
    {
        return jshInOutItemMapper.deleteJshInOutItemByIds(ids);
    }

    /**
     * 删除收支项目信息
     * 
     * @param id 收支项目主键
     * @return 结果
     */
    @Override
    public int deleteJshInOutItemById(Long id)
    {
        return jshInOutItemMapper.deleteJshInOutItemById(id);
    }
}
