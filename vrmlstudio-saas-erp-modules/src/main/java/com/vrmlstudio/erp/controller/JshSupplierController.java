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
import com.vrmlstudio.erp.domain.JshSupplier;
import com.vrmlstudio.erp.service.IJshSupplierService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 供应商/客户信息Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/supplier")
public class JshSupplierController extends BaseController
{
    @Autowired
    private IJshSupplierService jshSupplierService;

    /**
     * 查询供应商/客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshSupplier jshSupplier)
    {
        startPage();
        List<JshSupplier> list = jshSupplierService.selectJshSupplierList(jshSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商/客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:export')")
    @Log(title = "供应商/客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshSupplier jshSupplier)
    {
        List<JshSupplier> list = jshSupplierService.selectJshSupplierList(jshSupplier);
        ExcelUtil<JshSupplier> util = new ExcelUtil<JshSupplier>(JshSupplier.class);
        util.exportExcel(response, list, "供应商/客户信息数据");
    }

    /**
     * 获取供应商/客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshSupplierService.selectJshSupplierById(id));
    }

    /**
     * 新增供应商/客户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:add')")
    @Log(title = "供应商/客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshSupplier jshSupplier)
    {
        return toAjax(jshSupplierService.insertJshSupplier(jshSupplier));
    }

    /**
     * 修改供应商/客户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:edit')")
    @Log(title = "供应商/客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshSupplier jshSupplier)
    {
        return toAjax(jshSupplierService.updateJshSupplier(jshSupplier));
    }

    /**
     * 删除供应商/客户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:supplier:remove')")
    @Log(title = "供应商/客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshSupplierService.deleteJshSupplierByIds(ids));
    }
}
