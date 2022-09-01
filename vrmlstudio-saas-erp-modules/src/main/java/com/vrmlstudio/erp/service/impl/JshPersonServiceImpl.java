package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshPersonMapper;
import com.vrmlstudio.erp.domain.JshPerson;
import com.vrmlstudio.erp.service.IJshPersonService;

/**
 * 经手人Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshPersonServiceImpl implements IJshPersonService 
{
    @Autowired
    private JshPersonMapper jshPersonMapper;

    /**
     * 查询经手人
     * 
     * @param id 经手人主键
     * @return 经手人
     */
    @Override
    public JshPerson selectJshPersonById(Long id)
    {
        return jshPersonMapper.selectJshPersonById(id);
    }

    /**
     * 查询经手人列表
     * 
     * @param jshPerson 经手人
     * @return 经手人
     */
    @Override
    public List<JshPerson> selectJshPersonList(JshPerson jshPerson)
    {
        return jshPersonMapper.selectJshPersonList(jshPerson);
    }

    /**
     * 新增经手人
     * 
     * @param jshPerson 经手人
     * @return 结果
     */
    @Override
    public int insertJshPerson(JshPerson jshPerson)
    {
        return jshPersonMapper.insertJshPerson(jshPerson);
    }

    /**
     * 修改经手人
     * 
     * @param jshPerson 经手人
     * @return 结果
     */
    @Override
    public int updateJshPerson(JshPerson jshPerson)
    {
        return jshPersonMapper.updateJshPerson(jshPerson);
    }

    /**
     * 批量删除经手人
     * 
     * @param ids 需要删除的经手人主键
     * @return 结果
     */
    @Override
    public int deleteJshPersonByIds(Long[] ids)
    {
        return jshPersonMapper.deleteJshPersonByIds(ids);
    }

    /**
     * 删除经手人信息
     * 
     * @param id 经手人主键
     * @return 结果
     */
    @Override
    public int deleteJshPersonById(Long id)
    {
        return jshPersonMapper.deleteJshPersonById(id);
    }
}
