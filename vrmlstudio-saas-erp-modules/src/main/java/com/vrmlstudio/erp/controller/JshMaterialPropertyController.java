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
import com.vrmlstudio.erp.domain.JshMaterialProperty;
import com.vrmlstudio.erp.service.IJshMaterialPropertyService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品扩展字段Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/m_property")
public class JshMaterialPropertyController extends BaseController
{
    @Autowired
    private IJshMaterialPropertyService jshMaterialPropertyService;

    /**
     * 查询产品扩展字段列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterialProperty jshMaterialProperty)
    {
        startPage();
        List<JshMaterialProperty> list = jshMaterialPropertyService.selectJshMaterialPropertyList(jshMaterialProperty);
        return getDataTable(list);
    }

    /**
     * 导出产品扩展字段列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:export')")
    @Log(title = "产品扩展字段", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialProperty jshMaterialProperty)
    {
        List<JshMaterialProperty> list = jshMaterialPropertyService.selectJshMaterialPropertyList(jshMaterialProperty);
        ExcelUtil<JshMaterialProperty> util = new ExcelUtil<JshMaterialProperty>(JshMaterialProperty.class);
        util.exportExcel(response, list, "产品扩展字段数据");
    }

    /**
     * 获取产品扩展字段详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialPropertyService.selectJshMaterialPropertyById(id));
    }

    /**
     * 新增产品扩展字段
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:add')")
    @Log(title = "产品扩展字段", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialProperty jshMaterialProperty)
    {
        return toAjax(jshMaterialPropertyService.insertJshMaterialProperty(jshMaterialProperty));
    }

    /**
     * 修改产品扩展字段
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:edit')")
    @Log(title = "产品扩展字段", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialProperty jshMaterialProperty)
    {
        return toAjax(jshMaterialPropertyService.updateJshMaterialProperty(jshMaterialProperty));
    }

    /**
     * 删除产品扩展字段
     */
    @PreAuthorize("@ss.hasPermi('erp:m_property:remove')")
    @Log(title = "产品扩展字段", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialPropertyService.deleteJshMaterialPropertyByIds(ids));
    }
}
