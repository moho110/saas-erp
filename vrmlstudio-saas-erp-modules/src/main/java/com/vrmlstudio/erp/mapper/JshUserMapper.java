package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshUser;

/**
 * 用户Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public JshUser selectJshUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param jshUser 用户
     * @return 用户集合
     */
    public List<JshUser> selectJshUserList(JshUser jshUser);

    /**
     * 新增用户
     * 
     * @param jshUser 用户
     * @return 结果
     */
    public int insertJshUser(JshUser jshUser);

    /**
     * 修改用户
     * 
     * @param jshUser 用户
     * @return 结果
     */
    public int updateJshUser(JshUser jshUser);

    /**
     * 删除用户
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteJshUserById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshUserByIds(Long[] ids);
}
