package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMsgMapper;
import com.vrmlstudio.erp.domain.JshMsg;
import com.vrmlstudio.erp.service.IJshMsgService;

/**
 * 消息Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMsgServiceImpl implements IJshMsgService 
{
    @Autowired
    private JshMsgMapper jshMsgMapper;

    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    @Override
    public JshMsg selectJshMsgById(Long id)
    {
        return jshMsgMapper.selectJshMsgById(id);
    }

    /**
     * 查询消息列表
     * 
     * @param jshMsg 消息
     * @return 消息
     */
    @Override
    public List<JshMsg> selectJshMsgList(JshMsg jshMsg)
    {
        return jshMsgMapper.selectJshMsgList(jshMsg);
    }

    /**
     * 新增消息
     * 
     * @param jshMsg 消息
     * @return 结果
     */
    @Override
    public int insertJshMsg(JshMsg jshMsg)
    {
        jshMsg.setCreateTime(DateUtils.getNowDate());
        return jshMsgMapper.insertJshMsg(jshMsg);
    }

    /**
     * 修改消息
     * 
     * @param jshMsg 消息
     * @return 结果
     */
    @Override
    public int updateJshMsg(JshMsg jshMsg)
    {
        return jshMsgMapper.updateJshMsg(jshMsg);
    }

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteJshMsgByIds(Long[] ids)
    {
        return jshMsgMapper.deleteJshMsgByIds(ids);
    }

    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     * @return 结果
     */
    @Override
    public int deleteJshMsgById(Long id)
    {
        return jshMsgMapper.deleteJshMsgById(id);
    }
}
