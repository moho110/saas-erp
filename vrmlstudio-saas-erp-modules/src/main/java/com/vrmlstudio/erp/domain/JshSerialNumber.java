package com.vrmlstudio.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vrmlstudio.common.annotation.Excel;
import com.vrmlstudio.common.core.domain.BaseEntity;

/**
 * 序列号对象 jsh_serial_number
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public class JshSerialNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 产品表id */
    @Excel(name = "产品表id")
    private Long materialId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long depotId;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialNumber;

    /** 是否卖出，0未卖出，1卖出 */
    @Excel(name = "是否卖出，0未卖出，1卖出")
    private String isSell;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private Long updater;

    /** 入库单号 */
    @Excel(name = "入库单号")
    private String inBillNo;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String outBillNo;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }
    public void setIsSell(String isSell) 
    {
        this.isSell = isSell;
    }

    public String getIsSell() 
    {
        return isSell;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setUpdater(Long updater) 
    {
        this.updater = updater;
    }

    public Long getUpdater() 
    {
        return updater;
    }
    public void setInBillNo(String inBillNo) 
    {
        this.inBillNo = inBillNo;
    }

    public String getInBillNo() 
    {
        return inBillNo;
    }
    public void setOutBillNo(String outBillNo) 
    {
        this.outBillNo = outBillNo;
    }

    public String getOutBillNo() 
    {
        return outBillNo;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialId", getMaterialId())
            .append("depotId", getDepotId())
            .append("serialNumber", getSerialNumber())
            .append("isSell", getIsSell())
            .append("remark", getRemark())
            .append("deleteFlag", getDeleteFlag())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("updateTime", getUpdateTime())
            .append("updater", getUpdater())
            .append("inBillNo", getInBillNo())
            .append("outBillNo", getOutBillNo())
            .append("tenantId", getTenantId())
            .toString();
    }
}
