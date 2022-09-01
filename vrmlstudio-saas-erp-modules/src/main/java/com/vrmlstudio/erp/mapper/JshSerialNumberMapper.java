package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshSerialNumber;

/**
 * 序列号Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshSerialNumberMapper 
{
    /**
     * 查询序列号
     * 
     * @param id 序列号主键
     * @return 序列号
     */
    public JshSerialNumber selectJshSerialNumberById(Long id);

    /**
     * 查询序列号列表
     * 
     * @param jshSerialNumber 序列号
     * @return 序列号集合
     */
    public List<JshSerialNumber> selectJshSerialNumberList(JshSerialNumber jshSerialNumber);

    /**
     * 新增序列号
     * 
     * @param jshSerialNumber 序列号
     * @return 结果
     */
    public int insertJshSerialNumber(JshSerialNumber jshSerialNumber);

    /**
     * 修改序列号
     * 
     * @param jshSerialNumber 序列号
     * @return 结果
     */
    public int updateJshSerialNumber(JshSerialNumber jshSerialNumber);

    /**
     * 删除序列号
     * 
     * @param id 序列号主键
     * @return 结果
     */
    public int deleteJshSerialNumberById(Long id);

    /**
     * 批量删除序列号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshSerialNumberByIds(Long[] ids);
}
