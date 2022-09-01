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
import com.vrmlstudio.erp.domain.JshMaterial;
import com.vrmlstudio.erp.service.IJshMaterialService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/material")
public class JshMaterialController extends BaseController
{
    @Autowired
    private IJshMaterialService jshMaterialService;

    /**
     * 查询产品列表
     */
    @PreAuthorize("@ss.hasPermi('erp:material:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterial jshMaterial)
    {
        startPage();
        List<JshMaterial> list = jshMaterialService.selectJshMaterialList(jshMaterial);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @PreAuthorize("@ss.hasPermi('erp:material:export')")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterial jshMaterial)
    {
        List<JshMaterial> list = jshMaterialService.selectJshMaterialList(jshMaterial);
        ExcelUtil<JshMaterial> util = new ExcelUtil<JshMaterial>(JshMaterial.class);
        util.exportExcel(response, list, "产品数据");
    }

    /**
     * 获取产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:material:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialService.selectJshMaterialById(id));
    }

    /**
     * 新增产品
     */
    @PreAuthorize("@ss.hasPermi('erp:material:add')")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterial jshMaterial)
    {
        return toAjax(jshMaterialService.insertJshMaterial(jshMaterial));
    }

    /**
     * 修改产品
     */
    @PreAuthorize("@ss.hasPermi('erp:material:edit')")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterial jshMaterial)
    {
        return toAjax(jshMaterialService.updateJshMaterial(jshMaterial));
    }

    /**
     * 删除产品
     */
    @PreAuthorize("@ss.hasPermi('erp:material:remove')")
    @Log(title = "产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialService.deleteJshMaterialByIds(ids));
    }
}
