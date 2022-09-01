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
import com.vrmlstudio.erp.domain.JshMaterialAttribute;
import com.vrmlstudio.erp.service.IJshMaterialAttributeService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品属性Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/m_attribute")
public class JshMaterialAttributeController extends BaseController
{
    @Autowired
    private IJshMaterialAttributeService jshMaterialAttributeService;

    /**
     * 查询产品属性列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterialAttribute jshMaterialAttribute)
    {
        startPage();
        List<JshMaterialAttribute> list = jshMaterialAttributeService.selectJshMaterialAttributeList(jshMaterialAttribute);
        return getDataTable(list);
    }

    /**
     * 导出产品属性列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:export')")
    @Log(title = "产品属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialAttribute jshMaterialAttribute)
    {
        List<JshMaterialAttribute> list = jshMaterialAttributeService.selectJshMaterialAttributeList(jshMaterialAttribute);
        ExcelUtil<JshMaterialAttribute> util = new ExcelUtil<JshMaterialAttribute>(JshMaterialAttribute.class);
        util.exportExcel(response, list, "产品属性数据");
    }

    /**
     * 获取产品属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialAttributeService.selectJshMaterialAttributeById(id));
    }

    /**
     * 新增产品属性
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:add')")
    @Log(title = "产品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialAttribute jshMaterialAttribute)
    {
        return toAjax(jshMaterialAttributeService.insertJshMaterialAttribute(jshMaterialAttribute));
    }

    /**
     * 修改产品属性
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:edit')")
    @Log(title = "产品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialAttribute jshMaterialAttribute)
    {
        return toAjax(jshMaterialAttributeService.updateJshMaterialAttribute(jshMaterialAttribute));
    }

    /**
     * 删除产品属性
     */
    @PreAuthorize("@ss.hasPermi('erp:m_attribute:remove')")
    @Log(title = "产品属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialAttributeService.deleteJshMaterialAttributeByIds(ids));
    }
}
