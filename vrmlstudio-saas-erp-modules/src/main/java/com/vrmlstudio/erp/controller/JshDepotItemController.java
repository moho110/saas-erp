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
import com.vrmlstudio.erp.domain.JshDepotItem;
import com.vrmlstudio.erp.service.IJshDepotItemService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 单据子Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/depot_item")
public class JshDepotItemController extends BaseController
{
    @Autowired
    private IJshDepotItemService jshDepotItemService;

    /**
     * 查询单据子列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshDepotItem jshDepotItem)
    {
        startPage();
        List<JshDepotItem> list = jshDepotItemService.selectJshDepotItemList(jshDepotItem);
        return getDataTable(list);
    }

    /**
     * 导出单据子列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:export')")
    @Log(title = "单据子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshDepotItem jshDepotItem)
    {
        List<JshDepotItem> list = jshDepotItemService.selectJshDepotItemList(jshDepotItem);
        ExcelUtil<JshDepotItem> util = new ExcelUtil<JshDepotItem>(JshDepotItem.class);
        util.exportExcel(response, list, "单据子数据");
    }

    /**
     * 获取单据子详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshDepotItemService.selectJshDepotItemById(id));
    }

    /**
     * 新增单据子
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:add')")
    @Log(title = "单据子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshDepotItem jshDepotItem)
    {
        return toAjax(jshDepotItemService.insertJshDepotItem(jshDepotItem));
    }

    /**
     * 修改单据子
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:edit')")
    @Log(title = "单据子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshDepotItem jshDepotItem)
    {
        return toAjax(jshDepotItemService.updateJshDepotItem(jshDepotItem));
    }

    /**
     * 删除单据子
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_item:remove')")
    @Log(title = "单据子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshDepotItemService.deleteJshDepotItemByIds(ids));
    }
}
