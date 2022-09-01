package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshAccount;

/**
 * 账户信息Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshAccountMapper 
{
    /**
     * 查询账户信息
     * 
     * @param id 账户信息主键
     * @return 账户信息
     */
    public JshAccount selectJshAccountById(Long id);

    /**
     * 查询账户信息列表
     * 
     * @param jshAccount 账户信息
     * @return 账户信息集合
     */
    public List<JshAccount> selectJshAccountList(JshAccount jshAccount);

    /**
     * 新增账户信息
     * 
     * @param jshAccount 账户信息
     * @return 结果
     */
    public int insertJshAccount(JshAccount jshAccount);

    /**
     * 修改账户信息
     * 
     * @param jshAccount 账户信息
     * @return 结果
     */
    public int updateJshAccount(JshAccount jshAccount);

    /**
     * 删除账户信息
     * 
     * @param id 账户信息主键
     * @return 结果
     */
    public int deleteJshAccountById(Long id);

    /**
     * 批量删除账户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshAccountByIds(Long[] ids);
}
