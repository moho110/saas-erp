package com.vrmlstudio.erp.service;

import java.util.List;
import com.vrmlstudio.erp.domain.JshDepot;

/**
 * 仓库Service接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface IJshDepotService 
{
    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    public JshDepot selectJshDepotById(Long id);

    /**
     * 查询仓库列表
     * 
     * @param jshDepot 仓库
     * @return 仓库集合
     */
    public List<JshDepot> selectJshDepotList(JshDepot jshDepot);

    /**
     * 新增仓库
     * 
     * @param jshDepot 仓库
     * @return 结果
     */
    public int insertJshDepot(JshDepot jshDepot);

    /**
     * 修改仓库
     * 
     * @param jshDepot 仓库
     * @return 结果
     */
    public int updateJshDepot(JshDepot jshDepot);

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的仓库主键集合
     * @return 结果
     */
    public int deleteJshDepotByIds(Long[] ids);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteJshDepotById(Long id);
}
