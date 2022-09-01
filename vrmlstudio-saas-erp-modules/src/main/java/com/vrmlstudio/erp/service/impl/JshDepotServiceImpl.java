package com.vrmlstudio.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshDepotMapper;
import com.vrmlstudio.erp.domain.JshDepot;
import com.vrmlstudio.erp.service.IJshDepotService;

/**
 * 仓库Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshDepotServiceImpl implements IJshDepotService 
{
    @Autowired
    private JshDepotMapper jshDepotMapper;

    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    @Override
    public JshDepot selectJshDepotById(Long id)
    {
        return jshDepotMapper.selectJshDepotById(id);
    }

    /**
     * 查询仓库列表
     * 
     * @param jshDepot 仓库
     * @return 仓库
     */
    @Override
    public List<JshDepot> selectJshDepotList(JshDepot jshDepot)
    {
        return jshDepotMapper.selectJshDepotList(jshDepot);
    }

    /**
     * 新增仓库
     * 
     * @param jshDepot 仓库
     * @return 结果
     */
    @Override
    public int insertJshDepot(JshDepot jshDepot)
    {
        return jshDepotMapper.insertJshDepot(jshDepot);
    }

    /**
     * 修改仓库
     * 
     * @param jshDepot 仓库
     * @return 结果
     */
    @Override
    public int updateJshDepot(JshDepot jshDepot)
    {
        return jshDepotMapper.updateJshDepot(jshDepot);
    }

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的仓库主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotByIds(Long[] ids)
    {
        return jshDepotMapper.deleteJshDepotByIds(ids);
    }

    /**
     * 删除仓库信息
     * 
     * @param id 仓库主键
     * @return 结果
     */
    @Override
    public int deleteJshDepotById(Long id)
    {
        return jshDepotMapper.deleteJshDepotById(id);
    }
}
