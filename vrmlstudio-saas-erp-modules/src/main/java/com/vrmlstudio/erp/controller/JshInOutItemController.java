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
import com.vrmlstudio.erp.domain.JshInOutItem;
import com.vrmlstudio.erp.service.IJshInOutItemService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 收支项目Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/in_out_item")
public class JshInOutItemController extends BaseController
{
    @Autowired
    private IJshInOutItemService jshInOutItemService;

    /**
     * 查询收支项目列表
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshInOutItem jshInOutItem)
    {
        startPage();
        List<JshInOutItem> list = jshInOutItemService.selectJshInOutItemList(jshInOutItem);
        return getDataTable(list);
    }

    /**
     * 导出收支项目列表
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:export')")
    @Log(title = "收支项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshInOutItem jshInOutItem)
    {
        List<JshInOutItem> list = jshInOutItemService.selectJshInOutItemList(jshInOutItem);
        ExcelUtil<JshInOutItem> util = new ExcelUtil<JshInOutItem>(JshInOutItem.class);
        util.exportExcel(response, list, "收支项目数据");
    }

    /**
     * 获取收支项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshInOutItemService.selectJshInOutItemById(id));
    }

    /**
     * 新增收支项目
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:add')")
    @Log(title = "收支项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshInOutItem jshInOutItem)
    {
        return toAjax(jshInOutItemService.insertJshInOutItem(jshInOutItem));
    }

    /**
     * 修改收支项目
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:edit')")
    @Log(title = "收支项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshInOutItem jshInOutItem)
    {
        return toAjax(jshInOutItemService.updateJshInOutItem(jshInOutItem));
    }

    /**
     * 删除收支项目
     */
    @PreAuthorize("@ss.hasPermi('erp:in_out_item:remove')")
    @Log(title = "收支项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshInOutItemService.deleteJshInOutItemByIds(ids));
    }
}
