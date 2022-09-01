package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 单据编号对象 jsh_sequence
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshSequence extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列名称 */
    private String seqName;

    /** 最小值 */
    @Excel(name = "最小值")
    private Long minValue;

    /** 最大值 */
    @Excel(name = "最大值")
    private Long maxValue;

    /** 当前值 */
    @Excel(name = "当前值")
    private Long currentVal;

    /** 增长步数 */
    @Excel(name = "增长步数")
    private Long incrementVal;

    public void setSeqName(String seqName) 
    {
        this.seqName = seqName;
    }

    public String getSeqName() 
    {
        return seqName;
    }
    public void setMinValue(Long minValue) 
    {
        this.minValue = minValue;
    }

    public Long getMinValue() 
    {
        return minValue;
    }
    public void setMaxValue(Long maxValue) 
    {
        this.maxValue = maxValue;
    }

    public Long getMaxValue() 
    {
        return maxValue;
    }
    public void setCurrentVal(Long currentVal) 
    {
        this.currentVal = currentVal;
    }

    public Long getCurrentVal() 
    {
        return currentVal;
    }
    public void setIncrementVal(Long incrementVal) 
    {
        this.incrementVal = incrementVal;
    }

    public Long getIncrementVal() 
    {
        return incrementVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("seqName", getSeqName())
            .append("minValue", getMinValue())
            .append("maxValue", getMaxValue())
            .append("currentVal", getCurrentVal())
            .append("incrementVal", getIncrementVal())
            .append("remark", getRemark())
            .toString();
    }
}
