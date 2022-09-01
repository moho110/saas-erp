package com.vrmlstudio.erp.mapper;

import java.util.List;
import com.vrmlstudio.erp.domain.JshMaterialExtend;

/**
 * 产品价格扩展Mapper接口
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
public interface JshMaterialExtendMapper 
{
    /**
     * 查询产品价格扩展
     * 
     * @param id 产品价格扩展主键
     * @return 产品价格扩展
     */
    public JshMaterialExtend selectJshMaterialExtendById(Long id);

    /**
     * 查询产品价格扩展列表
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 产品价格扩展集合
     */
    public List<JshMaterialExtend> selectJshMaterialExtendList(JshMaterialExtend jshMaterialExtend);

    /**
     * 新增产品价格扩展
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 结果
     */
    public int insertJshMaterialExtend(JshMaterialExtend jshMaterialExtend);

    /**
     * 修改产品价格扩展
     * 
     * @param jshMaterialExtend 产品价格扩展
     * @return 结果
     */
    public int updateJshMaterialExtend(JshMaterialExtend jshMaterialExtend);

    /**
     * 删除产品价格扩展
     * 
     * @param id 产品价格扩展主键
     * @return 结果
     */
    public int deleteJshMaterialExtendById(Long id);

    /**
     * 批量删除产品价格扩展
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJshMaterialExtendByIds(Long[] ids);
}
