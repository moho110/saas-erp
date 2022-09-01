package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshUserMapper;
import com.vrmlstudio.erp.domain.JshUser;
import com.vrmlstudio.erp.service.IJshUserService;

/**
 * 用户Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshUserServiceImpl implements IJshUserService 
{
    @Autowired
    private JshUserMapper jshUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public JshUser selectJshUserById(Long id)
    {
        return jshUserMapper.selectJshUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param jshUser 用户
     * @return 用户
     */
    @Override
    public List<JshUser> selectJshUserList(JshUser jshUser)
    {
        return jshUserMapper.selectJshUserList(jshUser);
    }

    /**
     * 新增用户
     * 
     * @param jshUser 用户
     * @return 结果
     */
    @Override
    public int insertJshUser(JshUser jshUser)
    {
        return jshUserMapper.insertJshUser(jshUser);
    }

    /**
     * 修改用户
     * 
     * @param jshUser 用户
     * @return 结果
     */
    @Override
    public int updateJshUser(JshUser jshUser)
    {
        return jshUserMapper.updateJshUser(jshUser);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteJshUserByIds(Long[] ids)
    {
        return jshUserMapper.deleteJshUserByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteJshUserById(Long id)
    {
        return jshUserMapper.deleteJshUserById(id);
    }
}
