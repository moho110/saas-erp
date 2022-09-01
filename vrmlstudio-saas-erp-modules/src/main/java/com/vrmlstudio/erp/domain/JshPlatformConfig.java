package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 平台参数对象 jsh_platform_config
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshPlatformConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关键词 */
    @Excel(name = "关键词")
    private String platformKey;

    /** 关键词名称 */
    @Excel(name = "关键词名称")
    private String platformKeyInfo;

    /** 值 */
    @Excel(name = "值")
    private String platformValue;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlatformKey(String platformKey) 
    {
        this.platformKey = platformKey;
    }

    public String getPlatformKey() 
    {
        return platformKey;
    }
    public void setPlatformKeyInfo(String platformKeyInfo) 
    {
        this.platformKeyInfo = platformKeyInfo;
    }

    public String getPlatformKeyInfo() 
    {
        return platformKeyInfo;
    }
    public void setPlatformValue(String platformValue) 
    {
        this.platformValue = platformValue;
    }

    public String getPlatformValue() 
    {
        return platformValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("platformKey", getPlatformKey())
            .append("platformKeyInfo", getPlatformKeyInfo())
            .append("platformValue", getPlatformValue())
            .toString();
    }
}
