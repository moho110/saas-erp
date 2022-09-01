package com.vrmlstudio.erp.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vrmlstudio.common.annotation.Log;
import com.vrmlstudio.common.core.controller.BaseController;
import com.vrmlstudio.common.core.domain.AjaxResult;
import com.vrmlstudio.common.enums.BusinessType;
import com.vrmlstudio.erp.domain.JshMaterialExtend;
import com.vrmlstudio.erp.service.IJshMaterialExtendService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品价格扩展Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/m_extend")
public class JshMaterialExtendController extends BaseController
{
    @Autowired
    private IJshMaterialExtendService jshMaterialExtendService;

    /**
     * 查询产品价格扩展列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterialExtend jshMaterialExtend)
    {
        startPage();
        List<JshMaterialExtend> list = jshMaterialExtendService.selectJshMaterialExtendList(jshMaterialExtend);
        return getDataTable(list);
    }

    /**
     * 导出产品价格扩展列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:export')")
    @Log(title = "产品价格扩展", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialExtend jshMaterialExtend)
    {
        List<JshMaterialExtend> list = jshMaterialExtendService.selectJshMaterialExtendList(jshMaterialExtend);
        ExcelUtil<JshMaterialExtend> util = new ExcelUtil<JshMaterialExtend>(JshMaterialExtend.class);
        util.exportExcel(response, list, "产品价格扩展数据");
    }

    /**
     * 获取产品价格扩展详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialExtendService.selectJshMaterialExtendById(id));
    }

    /**
     * 新增产品价格扩展
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:add')")
    @Log(title = "产品价格扩展", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialExtend jshMaterialExtend)
    {
        return toAjax(jshMaterialExtendService.insertJshMaterialExtend(jshMaterialExtend));
    }

    /**
     * 修改产品价格扩展
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:edit')")
    @Log(title = "产品价格扩展", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialExtend jshMaterialExtend)
    {
        return toAjax(jshMaterialExtendService.updateJshMaterialExtend(jshMaterialExtend));
    }

    /**
     * 删除产品价格扩展
     */
    @PreAuthorize("@ss.hasPermi('erp:m_extend:remove')")
    @Log(title = "产品价格扩展", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialExtendService.deleteJshMaterialExtendByIds(ids));
    }
}
