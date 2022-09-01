package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshLogMapper;
import com.vrmlstudio.erp.domain.JshLog;
import com.vrmlstudio.erp.service.IJshLogService;

/**
 * 操作日志Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshLogServiceImpl implements IJshLogService 
{
    @Autowired
    private JshLogMapper jshLogMapper;

    /**
     * 查询操作日志
     * 
     * @param id 操作日志主键
     * @return 操作日志
     */
    @Override
    public JshLog selectJshLogById(Long id)
    {
        return jshLogMapper.selectJshLogById(id);
    }

    /**
     * 查询操作日志列表
     * 
     * @param jshLog 操作日志
     * @return 操作日志
     */
    @Override
    public List<JshLog> selectJshLogList(JshLog jshLog)
    {
        return jshLogMapper.selectJshLogList(jshLog);
    }

    /**
     * 新增操作日志
     * 
     * @param jshLog 操作日志
     * @return 结果
     */
    @Override
    public int insertJshLog(JshLog jshLog)
    {
        jshLog.setCreateTime(DateUtils.getNowDate());
        return jshLogMapper.insertJshLog(jshLog);
    }

    /**
     * 修改操作日志
     * 
     * @param jshLog 操作日志
     * @return 结果
     */
    @Override
    public int updateJshLog(JshLog jshLog)
    {
        return jshLogMapper.updateJshLog(jshLog);
    }

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的操作日志主键
     * @return 结果
     */
    @Override
    public int deleteJshLogByIds(Long[] ids)
    {
        return jshLogMapper.deleteJshLogByIds(ids);
    }

    /**
     * 删除操作日志信息
     * 
     * @param id 操作日志主键
     * @return 结果
     */
    @Override
    public int deleteJshLogById(Long id)
    {
        return jshLogMapper.deleteJshLogById(id);
    }
}
