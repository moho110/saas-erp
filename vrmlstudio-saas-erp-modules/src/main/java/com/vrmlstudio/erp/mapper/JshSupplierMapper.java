package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshSupplier;

/**
 * 供应商/客户信息Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshSupplierMapper 
{
    /**
     * 查询供应商/客户信息
     * 
     * @param id 供应商/客户信息主键
     * @return 供应商/客户信息
     */
    public JshSupplier selectJshSupplierById(Long id);

    /**
     * 查询供应商/客户信息列表
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 供应商/客户信息集合
     */
    public List<JshSupplier> selectJshSupplierList(JshSupplier jshSupplier);

    /**
     * 新增供应商/客户信息
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 结果
     */
    public int insertJshSupplier(JshSupplier jshSupplier);

    /**
     * 修改供应商/客户信息
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 结果
     */
    public int updateJshSupplier(JshSupplier jshSupplier);

    /**
     * 删除供应商/客户信息
     * 
     * @param id 供应商/客户信息主键
     * @return 结果
     */
    public int deleteJshSupplierById(Long id);

    /**
     * 批量删除供应商/客户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshSupplierByIds(Long[] ids);
}
