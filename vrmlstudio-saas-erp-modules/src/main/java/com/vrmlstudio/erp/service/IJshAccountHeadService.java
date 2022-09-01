package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshAccountHead;

/**
 * 财务主Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshAccountHeadService 
{
    /**
     * 查询财务主
     * 
     * @param id 财务主主键
     * @return 财务主
     */
    public JshAccountHead selectJshAccountHeadById(Long id);

    /**
     * 查询财务主列表
     * 
     * @param jshAccountHead 财务主
     * @return 财务主集合
     */
    public List<JshAccountHead> selectJshAccountHeadList(JshAccountHead jshAccountHead);

    /**
     * 新增财务主
     * 
     * @param jshAccountHead 财务主
     * @return 结果
     */
    public int insertJshAccountHead(JshAccountHead jshAccountHead);

    /**
     * 修改财务主
     * 
     * @param jshAccountHead 财务主
     * @return 结果
     */
    public int updateJshAccountHead(JshAccountHead jshAccountHead);

    /**
     * 批量删除财务主
     * 
     * @param ids 需要删除的财务主主键集合
     * @return 结果
     */
    public int deleteJshAccountHeadByIds(Long[] ids);

    /**
     * 删除财务主信息
     * 
     * @param id 财务主主键
     * @return 结果
     */
    public int deleteJshAccountHeadById(Long id);
}
