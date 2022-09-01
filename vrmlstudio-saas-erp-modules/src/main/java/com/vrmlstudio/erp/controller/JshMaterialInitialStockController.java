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
import com.vrmlstudio.erp.domain.JshMaterialInitialStock;
import com.vrmlstudio.erp.service.IJshMaterialInitialStockService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品初始库存Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/init_stock")
public class JshMaterialInitialStockController extends BaseController
{
    @Autowired
    private IJshMaterialInitialStockService jshMaterialInitialStockService;

    /**
     * 查询产品初始库存列表
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterialInitialStock jshMaterialInitialStock)
    {
        startPage();
        List<JshMaterialInitialStock> list = jshMaterialInitialStockService.selectJshMaterialInitialStockList(jshMaterialInitialStock);
        return getDataTable(list);
    }

    /**
     * 导出产品初始库存列表
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:export')")
    @Log(title = "产品初始库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialInitialStock jshMaterialInitialStock)
    {
        List<JshMaterialInitialStock> list = jshMaterialInitialStockService.selectJshMaterialInitialStockList(jshMaterialInitialStock);
        ExcelUtil<JshMaterialInitialStock> util = new ExcelUtil<JshMaterialInitialStock>(JshMaterialInitialStock.class);
        util.exportExcel(response, list, "产品初始库存数据");
    }

    /**
     * 获取产品初始库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialInitialStockService.selectJshMaterialInitialStockById(id));
    }

    /**
     * 新增产品初始库存
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:add')")
    @Log(title = "产品初始库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialInitialStock jshMaterialInitialStock)
    {
        return toAjax(jshMaterialInitialStockService.insertJshMaterialInitialStock(jshMaterialInitialStock));
    }

    /**
     * 修改产品初始库存
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:edit')")
    @Log(title = "产品初始库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialInitialStock jshMaterialInitialStock)
    {
        return toAjax(jshMaterialInitialStockService.updateJshMaterialInitialStock(jshMaterialInitialStock));
    }

    /**
     * 删除产品初始库存
     */
    @PreAuthorize("@ss.hasPermi('erp:init_stock:remove')")
    @Log(title = "产品初始库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialInitialStockService.deleteJshMaterialInitialStockByIds(ids));
    }
}
