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
import com.vrmlstudio.erp.domain.JshMaterialCategory;
import com.vrmlstudio.erp.service.IJshMaterialCategoryService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;

/**
 * 产品类型Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/m_category")
public class JshMaterialCategoryController extends BaseController
{
    @Autowired
    private IJshMaterialCategoryService jshMaterialCategoryService;

    /**
     * 查询产品类型列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:list')")
    @GetMapping("/list")
    public AjaxResult list(JshMaterialCategory jshMaterialCategory)
    {
        List<JshMaterialCategory> list = jshMaterialCategoryService.selectJshMaterialCategoryList(jshMaterialCategory);
        return AjaxResult.success(list);
    }

    /**
     * 导出产品类型列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:export')")
    @Log(title = "产品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialCategory jshMaterialCategory)
    {
        List<JshMaterialCategory> list = jshMaterialCategoryService.selectJshMaterialCategoryList(jshMaterialCategory);
        ExcelUtil<JshMaterialCategory> util = new ExcelUtil<JshMaterialCategory>(JshMaterialCategory.class);
        util.exportExcel(response, list, "产品类型数据");
    }

    /**
     * 获取产品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialCategoryService.selectJshMaterialCategoryById(id));
    }

    /**
     * 新增产品类型
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:add')")
    @Log(title = "产品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialCategory jshMaterialCategory)
    {
        return toAjax(jshMaterialCategoryService.insertJshMaterialCategory(jshMaterialCategory));
    }

    /**
     * 修改产品类型
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:edit')")
    @Log(title = "产品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialCategory jshMaterialCategory)
    {
        return toAjax(jshMaterialCategoryService.updateJshMaterialCategory(jshMaterialCategory));
    }

    /**
     * 删除产品类型
     */
    @PreAuthorize("@ss.hasPermi('erp:m_category:remove')")
    @Log(title = "产品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialCategoryService.deleteJshMaterialCategoryByIds(ids));
    }
}
