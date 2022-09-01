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
import com.vrmlstudio.erp.domain.JshMaterialCurrentStock;
import com.vrmlstudio.erp.service.IJshMaterialCurrentStockService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 产品当前库存Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/m_current_stock")
public class JshMaterialCurrentStockController extends BaseController
{
    @Autowired
    private IJshMaterialCurrentStockService jshMaterialCurrentStockService;

    /**
     * 查询产品当前库存列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        startPage();
        List<JshMaterialCurrentStock> list = jshMaterialCurrentStockService.selectJshMaterialCurrentStockList(jshMaterialCurrentStock);
        return getDataTable(list);
    }

    /**
     * 导出产品当前库存列表
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:export')")
    @Log(title = "产品当前库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        List<JshMaterialCurrentStock> list = jshMaterialCurrentStockService.selectJshMaterialCurrentStockList(jshMaterialCurrentStock);
        ExcelUtil<JshMaterialCurrentStock> util = new ExcelUtil<JshMaterialCurrentStock>(JshMaterialCurrentStock.class);
        util.exportExcel(response, list, "产品当前库存数据");
    }

    /**
     * 获取产品当前库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMaterialCurrentStockService.selectJshMaterialCurrentStockById(id));
    }

    /**
     * 新增产品当前库存
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:add')")
    @Log(title = "产品当前库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        return toAjax(jshMaterialCurrentStockService.insertJshMaterialCurrentStock(jshMaterialCurrentStock));
    }

    /**
     * 修改产品当前库存
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:edit')")
    @Log(title = "产品当前库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMaterialCurrentStock jshMaterialCurrentStock)
    {
        return toAjax(jshMaterialCurrentStockService.updateJshMaterialCurrentStock(jshMaterialCurrentStock));
    }

    /**
     * 删除产品当前库存
     */
    @PreAuthorize("@ss.hasPermi('erp:m_current_stock:remove')")
    @Log(title = "产品当前库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMaterialCurrentStockService.deleteJshMaterialCurrentStockByIds(ids));
    }
}
