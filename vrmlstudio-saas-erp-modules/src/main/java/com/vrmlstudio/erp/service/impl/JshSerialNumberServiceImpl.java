package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshSerialNumberMapper;
import com.vrmlstudio.erp.domain.JshSerialNumber;
import com.vrmlstudio.erp.service.IJshSerialNumberService;

/**
 * 序列号Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshSerialNumberServiceImpl implements IJshSerialNumberService 
{
    @Autowired
    private JshSerialNumberMapper jshSerialNumberMapper;

    /**
     * 查询序列号
     * 
     * @param id 序列号主键
     * @return 序列号
     */
    @Override
    public JshSerialNumber selectJshSerialNumberById(Long id)
    {
        return jshSerialNumberMapper.selectJshSerialNumberById(id);
    }

    /**
     * 查询序列号列表
     * 
     * @param jshSerialNumber 序列号
     * @return 序列号
     */
    @Override
    public List<JshSerialNumber> selectJshSerialNumberList(JshSerialNumber jshSerialNumber)
    {
        return jshSerialNumberMapper.selectJshSerialNumberList(jshSerialNumber);
    }

    /**
     * 新增序列号
     * 
     * @param jshSerialNumber 序列号
     * @return 结果
     */
    @Override
    public int insertJshSerialNumber(JshSerialNumber jshSerialNumber)
    {
        jshSerialNumber.setCreateTime(DateUtils.getNowDate());
        return jshSerialNumberMapper.insertJshSerialNumber(jshSerialNumber);
    }

    /**
     * 修改序列号
     * 
     * @param jshSerialNumber 序列号
     * @return 结果
     */
    @Override
    public int updateJshSerialNumber(JshSerialNumber jshSerialNumber)
    {
        jshSerialNumber.setUpdateTime(DateUtils.getNowDate());
        return jshSerialNumberMapper.updateJshSerialNumber(jshSerialNumber);
    }

    /**
     * 批量删除序列号
     * 
     * @param ids 需要删除的序列号主键
     * @return 结果
     */
    @Override
    public int deleteJshSerialNumberByIds(Long[] ids)
    {
        return jshSerialNumberMapper.deleteJshSerialNumberByIds(ids);
    }

    /**
     * 删除序列号信息
     * 
     * @param id 序列号主键
     * @return 结果
     */
    @Override
    public int deleteJshSerialNumberById(Long id)
    {
        return jshSerialNumberMapper.deleteJshSerialNumberById(id);
    }
}
