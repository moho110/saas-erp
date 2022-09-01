package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshAccountHeadMapper;
import com.vrmlstudio.erp.domain.JshAccountHead;
import com.vrmlstudio.erp.service.IJshAccountHeadService;

/**
 * 财务主Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshAccountHeadServiceImpl implements IJshAccountHeadService 
{
    @Autowired
    private JshAccountHeadMapper jshAccountHeadMapper;

    /**
     * 查询财务主
     * 
     * @param id 财务主主键
     * @return 财务主
     */
    @Override
    public JshAccountHead selectJshAccountHeadById(Long id)
    {
        return jshAccountHeadMapper.selectJshAccountHeadById(id);
    }

    /**
     * 查询财务主列表
     * 
     * @param jshAccountHead 财务主
     * @return 财务主
     */
    @Override
    public List<JshAccountHead> selectJshAccountHeadList(JshAccountHead jshAccountHead)
    {
        return jshAccountHeadMapper.selectJshAccountHeadList(jshAccountHead);
    }

    /**
     * 新增财务主
     * 
     * @param jshAccountHead 财务主
     * @return 结果
     */
    @Override
    public int insertJshAccountHead(JshAccountHead jshAccountHead)
    {
        return jshAccountHeadMapper.insertJshAccountHead(jshAccountHead);
    }

    /**
     * 修改财务主
     * 
     * @param jshAccountHead 财务主
     * @return 结果
     */
    @Override
    public int updateJshAccountHead(JshAccountHead jshAccountHead)
    {
        return jshAccountHeadMapper.updateJshAccountHead(jshAccountHead);
    }

    /**
     * 批量删除财务主
     * 
     * @param ids 需要删除的财务主主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountHeadByIds(Long[] ids)
    {
        return jshAccountHeadMapper.deleteJshAccountHeadByIds(ids);
    }

    /**
     * 删除财务主信息
     * 
     * @param id 财务主主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountHeadById(Long id)
    {
        return jshAccountHeadMapper.deleteJshAccountHeadById(id);
    }
}
