package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshSupplierMapper;
import com.vrmlstudio.erp.domain.JshSupplier;
import com.vrmlstudio.erp.service.IJshSupplierService;

/**
 * 供应商/客户信息Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshSupplierServiceImpl implements IJshSupplierService 
{
    @Autowired
    private JshSupplierMapper jshSupplierMapper;

    /**
     * 查询供应商/客户信息
     * 
     * @param id 供应商/客户信息主键
     * @return 供应商/客户信息
     */
    @Override
    public JshSupplier selectJshSupplierById(Long id)
    {
        return jshSupplierMapper.selectJshSupplierById(id);
    }

    /**
     * 查询供应商/客户信息列表
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 供应商/客户信息
     */
    @Override
    public List<JshSupplier> selectJshSupplierList(JshSupplier jshSupplier)
    {
        return jshSupplierMapper.selectJshSupplierList(jshSupplier);
    }

    /**
     * 新增供应商/客户信息
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 结果
     */
    @Override
    public int insertJshSupplier(JshSupplier jshSupplier)
    {
        return jshSupplierMapper.insertJshSupplier(jshSupplier);
    }

    /**
     * 修改供应商/客户信息
     * 
     * @param jshSupplier 供应商/客户信息
     * @return 结果
     */
    @Override
    public int updateJshSupplier(JshSupplier jshSupplier)
    {
        return jshSupplierMapper.updateJshSupplier(jshSupplier);
    }

    /**
     * 批量删除供应商/客户信息
     * 
     * @param ids 需要删除的供应商/客户信息主键
     * @return 结果
     */
    @Override
    public int deleteJshSupplierByIds(Long[] ids)
    {
        return jshSupplierMapper.deleteJshSupplierByIds(ids);
    }

    /**
     * 删除供应商/客户信息信息
     * 
     * @param id 供应商/客户信息主键
     * @return 结果
     */
    @Override
    public int deleteJshSupplierById(Long id)
    {
        return jshSupplierMapper.deleteJshSupplierById(id);
    }
}
