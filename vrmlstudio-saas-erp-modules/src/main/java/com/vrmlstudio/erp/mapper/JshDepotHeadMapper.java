package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshDepotHead;

/**
 * 单据主Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshDepotHeadMapper 
{
    /**
     * 查询单据主
     * 
     * @param id 单据主主键
     * @return 单据主
     */
    public JshDepotHead selectJshDepotHeadById(Long id);

    /**
     * 查询单据主列表
     * 
     * @param jshDepotHead 单据主
     * @return 单据主集合
     */
    public List<JshDepotHead> selectJshDepotHeadList(JshDepotHead jshDepotHead);

    /**
     * 新增单据主
     * 
     * @param jshDepotHead 单据主
     * @return 结果
     */
    public int insertJshDepotHead(JshDepotHead jshDepotHead);

    /**
     * 修改单据主
     * 
     * @param jshDepotHead 单据主
     * @return 结果
     */
    public int updateJshDepotHead(JshDepotHead jshDepotHead);

    /**
     * 删除单据主
     * 
     * @param id 单据主主键
     * @return 结果
     */
    public int deleteJshDepotHeadById(Long id);

    /**
     * 批量删除单据主
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshDepotHeadByIds(Long[] ids);
}
