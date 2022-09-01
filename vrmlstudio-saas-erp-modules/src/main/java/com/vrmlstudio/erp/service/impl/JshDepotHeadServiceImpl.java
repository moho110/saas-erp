package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshDepotHeadMapper;
import com.vrmlstudio.erp.domain.JshDepotHead;
import com.vrmlstudio.erp.service.IJshDepotHeadService;

/**
 * 单据主Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshDepotHeadServiceImpl implements IJshDepotHeadService 
{
    @Autowired
    private JshDepotHeadMapper jshDepotHeadMapper;

    /**
     * 查询单据主
     * 
     * @param id 单据主主键
     * @return 单据主
     */
    @Override
    public JshDepotHead selectJshDepotHeadById(Long id)
    {
        return jshDepotHeadMapper.selectJshDepotHeadById(id);
    }

    /**
     * 查询单据主列表
     * 
     * @param jshDepotHead 单据主
     * @return 单据主
     */
    @Override
    public List<JshDepotHead> selectJshDepotHeadList(JshDepotHead jshDepotHead)
    {
        return jshDepotHeadMapper.selectJshDepotHeadList(jshDepotHead);
    }

    /**
     * 新增单据主
     * 
     * @param jshDepotHead 单据主
     * @return 结果
     */
    @Override
    public int insertJshDepotHead(JshDepotHead jshDepotHead)
    {
        jshDepotHead.setCreateTime(DateUtils.getNowDate());
        return jshDepotHeadMapper.insertJshDepotHead(jshDepotHead);
    }

    /**
     * 修改单据主
     * 
     * @param jshDepotHead 单据主
     * @return 结果
     */
    @Override
    public int updateJshDepotHead(JshDepotHead jshDepotHead)
    {
        return jshDepotHeadMapper.updateJshDepotHead(jshDepotHead);
    }

    /**
     * 批量删除单据主
     * 
     * @param ids 需要删除的单据主主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotHeadByIds(Long[] ids)
    {
        return jshDepotHeadMapper.deleteJshDepotHeadByIds(ids);
    }

    /**
     * 删除单据主信息
     * 
     * @param id 单据主主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotHeadById(Long id)
    {
        return jshDepotHeadMapper.deleteJshDepotHeadById(id);
    }
}
