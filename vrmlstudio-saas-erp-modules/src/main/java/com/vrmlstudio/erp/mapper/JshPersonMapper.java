package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshPerson;

/**
 * 经手人Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshPersonMapper 
{
    /**
     * 查询经手人
     * 
     * @param id 经手人主键
     * @return 经手人
     */
    public JshPerson selectJshPersonById(Long id);

    /**
     * 查询经手人列表
     * 
     * @param jshPerson 经手人
     * @return 经手人集合
     */
    public List<JshPerson> selectJshPersonList(JshPerson jshPerson);

    /**
     * 新增经手人
     * 
     * @param jshPerson 经手人
     * @return 结果
     */
    public int insertJshPerson(JshPerson jshPerson);

    /**
     * 修改经手人
     * 
     * @param jshPerson 经手人
     * @return 结果
     */
    public int updateJshPerson(JshPerson jshPerson);

    /**
     * 删除经手人
     * 
     * @param id 经手人主键
     * @return 结果
     */
    public int deleteJshPersonById(Long id);

    /**
     * 批量删除经手人
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshPersonByIds(Long[] ids);
}
