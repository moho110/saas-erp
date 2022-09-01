package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshLog;

/**
 * 操作日志Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshLogMapper 
{
    /**
     * 查询操作日志
     * 
     * @param id 操作日志主键
     * @return 操作日志
     */
    public JshLog selectJshLogById(Long id);

    /**
     * 查询操作日志列表
     * 
     * @param jshLog 操作日志
     * @return 操作日志集合
     */
    public List<JshLog> selectJshLogList(JshLog jshLog);

    /**
     * 新增操作日志
     * 
     * @param jshLog 操作日志
     * @return 结果
     */
    public int insertJshLog(JshLog jshLog);

    /**
     * 修改操作日志
     * 
     * @param jshLog 操作日志
     * @return 结果
     */
    public int updateJshLog(JshLog jshLog);

    /**
     * 删除操作日志
     * 
     * @param id 操作日志主键
     * @return 结果
     */
    public int deleteJshLogById(Long id);

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshLogByIds(Long[] ids);
}
