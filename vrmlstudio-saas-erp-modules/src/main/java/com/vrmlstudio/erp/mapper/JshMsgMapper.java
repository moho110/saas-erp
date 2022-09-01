package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMsg;

/**
 * 消息Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshMsgMapper 
{
    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    public JshMsg selectJshMsgById(Long id);

    /**
     * 查询消息列表
     * 
     * @param jshMsg 消息
     * @return 消息集合
     */
    public List<JshMsg> selectJshMsgList(JshMsg jshMsg);

    /**
     * 新增消息
     * 
     * @param jshMsg 消息
     * @return 结果
     */
    public int insertJshMsg(JshMsg jshMsg);

    /**
     * 修改消息
     * 
     * @param jshMsg 消息
     * @return 结果
     */
    public int updateJshMsg(JshMsg jshMsg);

    /**
     * 删除消息
     * 
     * @param id 消息主键
     * @return 结果
     */
    public int deleteJshMsgById(Long id);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshMsgByIds(Long[] ids);
}
