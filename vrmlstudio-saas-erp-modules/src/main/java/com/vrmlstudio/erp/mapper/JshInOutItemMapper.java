package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshInOutItem;

/**
 * 收支项目Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshInOutItemMapper 
{
    /**
     * 查询收支项目
     * 
     * @param id 收支项目主键
     * @return 收支项目
     */
    public JshInOutItem selectJshInOutItemById(Long id);

    /**
     * 查询收支项目列表
     * 
     * @param jshInOutItem 收支项目
     * @return 收支项目集合
     */
    public List<JshInOutItem> selectJshInOutItemList(JshInOutItem jshInOutItem);

    /**
     * 新增收支项目
     * 
     * @param jshInOutItem 收支项目
     * @return 结果
     */
    public int insertJshInOutItem(JshInOutItem jshInOutItem);

    /**
     * 修改收支项目
     * 
     * @param jshInOutItem 收支项目
     * @return 结果
     */
    public int updateJshInOutItem(JshInOutItem jshInOutItem);

    /**
     * 删除收支项目
     * 
     * @param id 收支项目主键
     * @return 结果
     */
    public int deleteJshInOutItemById(Long id);

    /**
     * 批量删除收支项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshInOutItemByIds(Long[] ids);
}
