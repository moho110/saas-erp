package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshSequenceMapper;
import com.vrmlstudio.erp.domain.JshSequence;
import com.vrmlstudio.erp.service.IJshSequenceService;

/**
 * 单据编号Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshSequenceServiceImpl implements IJshSequenceService 
{
    @Autowired
    private JshSequenceMapper jshSequenceMapper;

    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号主键
     * @return 单据编号
     */
    @Override
    public JshSequence selectJshSequenceBySeqName(String seqName)
    {
        return jshSequenceMapper.selectJshSequenceBySeqName(seqName);
    }

    /**
     * 查询单据编号列表
     * 
     * @param jshSequence 单据编号
     * @return 单据编号
     */
    @Override
    public List<JshSequence> selectJshSequenceList(JshSequence jshSequence)
    {
        return jshSequenceMapper.selectJshSequenceList(jshSequence);
    }

    /**
     * 新增单据编号
     * 
     * @param jshSequence 单据编号
     * @return 结果
     */
    @Override
    public int insertJshSequence(JshSequence jshSequence)
    {
        return jshSequenceMapper.insertJshSequence(jshSequence);
    }

    /**
     * 修改单据编号
     * 
     * @param jshSequence 单据编号
     * @return 结果
     */
    @Override
    public int updateJshSequence(JshSequence jshSequence)
    {
        return jshSequenceMapper.updateJshSequence(jshSequence);
    }

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的单据编号主键
     * @return 结果
     */
    @Override
    public int deleteJshSequenceBySeqNames(String[] seqNames)
    {
        return jshSequenceMapper.deleteJshSequenceBySeqNames(seqNames);
    }

    /**
     * 删除单据编号信息
     * 
     * @param seqName 单据编号主键
     * @return 结果
     */
    @Override
    public int deleteJshSequenceBySeqName(String seqName)
    {
        return jshSequenceMapper.deleteJshSequenceBySeqName(seqName);
    }
}
