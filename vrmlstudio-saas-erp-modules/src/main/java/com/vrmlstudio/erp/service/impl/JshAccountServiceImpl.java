package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshAccountMapper;
import com.vrmlstudio.erp.domain.JshAccount;
import com.vrmlstudio.erp.service.IJshAccountService;

/**
 * 账户信息Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshAccountServiceImpl implements IJshAccountService 
{
    @Autowired
    private JshAccountMapper jshAccountMapper;

    /**
     * 查询账户信息
     * 
     * @param id 账户信息主键
     * @return 账户信息
     */
    @Override
    public JshAccount selectJshAccountById(Long id)
    {
        return jshAccountMapper.selectJshAccountById(id);
    }

    /**
     * 查询账户信息列表
     * 
     * @param jshAccount 账户信息
     * @return 账户信息
     */
    @Override
    public List<JshAccount> selectJshAccountList(JshAccount jshAccount)
    {
        return jshAccountMapper.selectJshAccountList(jshAccount);
    }

    /**
     * 新增账户信息
     * 
     * @param jshAccount 账户信息
     * @return 结果
     */
    @Override
    public int insertJshAccount(JshAccount jshAccount)
    {
        return jshAccountMapper.insertJshAccount(jshAccount);
    }

    /**
     * 修改账户信息
     * 
     * @param jshAccount 账户信息
     * @return 结果
     */
    @Override
    public int updateJshAccount(JshAccount jshAccount)
    {
        return jshAccountMapper.updateJshAccount(jshAccount);
    }

    /**
     * 批量删除账户信息
     * 
     * @param ids 需要删除的账户信息主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountByIds(Long[] ids)
    {
        return jshAccountMapper.deleteJshAccountByIds(ids);
    }

    /**
     * 删除账户信息信息
     * 
     * @param id 账户信息主键
     * @return 结果
     */
    @Override
    public int deleteJshAccountById(Long id)
    {
        return jshAccountMapper.deleteJshAccountById(id);
    }
}
