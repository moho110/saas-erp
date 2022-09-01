package com.vrmlstudio.erp.service.impl;

import java.util.List;
import com.vrmlstudio.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrmlstudio.erp.mapper.JshMaterialExtendMapper;
import com.vrmlstudio.erp.domain.JshMaterialExtend;
import com.vrmlstudio.erp.service.IJshMaterialExtendService;

/**
 * 产品价格扩展Service业务层处理
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@Service
public class JshMaterialExtendServiceImpl implements IJshMaterialExtendService 
{
    @Autowired
    private JshMaterialExtendMapper jshMaterialExtendMapper;

    /**
     * 查询产品价格扩展
     * 
     * @param id 产品价格扩展主键
     * @return 产品价格扩展
     */
    @Override
    public JshMaterialExtend selectJshMaterialExtendById(Long id)
    {
        return jshMaterialExtendMapper.selectJshMaterialExtendById(id);
    }

    /**
     * 查询产品价格扩展列表
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 产品价格扩展
     */
    @Override
    public List<JshMaterialExtend> selectJshMaterialExtendList(JshMaterialExtend jshMaterialExtend)
    {
        return jshMaterialExtendMapper.selectJshMaterialExtendList(jshMaterialExtend);
    }

    /**
     * 新增产品价格扩展
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 结果
     */
    @Override
    public int insertJshMaterialExtend(JshMaterialExtend jshMaterialExtend)
    {
        jshMaterialExtend.setCreateTime(DateUtils.getNowDate());
        return jshMaterialExtendMapper.insertJshMaterialExtend(jshMaterialExtend);
    }

    /**
     * 修改产品价格扩展
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 结果
     */
    @Override
    public int updateJshMaterialExtend(JshMaterialExtend jshMaterialExtend)
    {
        jshMaterialExtend.setUpdateTime(DateUtils.getNowDate());
        return jshMaterialExtendMapper.updateJshMaterialExtend(jshMaterialExtend);
    }

    /**
     * 批量删除产品价格扩展
     * 
     * @param ids 需要删除的产品价格扩展主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialExtendByIds(Long[] ids)
    {
        return jshMaterialExtendMapper.deleteJshMaterialExtendByIds(ids);
    }

    /**
     * 删除产品价格扩展信息
     * 
     * @param id 产品价格扩展主键
     * @return 结果
     */
    @Override
    public int deleteJshMaterialExtendById(Long id)
    {
        return jshMaterialExtendMapper.deleteJshMaterialExtendById(id);
    }
}
