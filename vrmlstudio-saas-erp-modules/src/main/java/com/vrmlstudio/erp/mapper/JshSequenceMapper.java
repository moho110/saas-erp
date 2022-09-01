package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshSequence;

/**
 * 单据编号Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshSequenceMapper 
{
    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号主键
     * @return 单据编号
     */
    public JshSequence selectJshSequenceBySeqName(String seqName);

    /**
     * 查询单据编号列表
     * 
     * @param jshSequence 单据编号
     * @return 单据编号集合
     */
    public List<JshSequence> selectJshSequenceList(JshSequence jshSequence);

    /**
     * 新增单据编号
     * 
     * @param jshSequence 单据编号
     * @return 结果
     */
    public int insertJshSequence(JshSequence jshSequence);

    /**
     * 修改单据编号
     * 
     * @param jshSequence 单据编号
     * @return 结果
     */
    public int updateJshSequence(JshSequence jshSequence);

    /**
     * 删除单据编号
     * 
     * @param seqName 单据编号主键
     * @return 结果
     */
    public int deleteJshSequenceBySeqName(String seqName);

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshSequenceBySeqNames(String[] seqNames);
}
