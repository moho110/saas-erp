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
import com.vrmlstudio.erp.domain.JshAccountItem;
import com.vrmlstudio.erp.service.IJshAccountItemService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 财务子Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/act_item")
public class JshAccountItemController extends BaseController
{
    @Autowired
    private IJshAccountItemService jshAccountItemService;

    /**
     * 查询财务子列表
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshAccountItem jshAccountItem)
    {
        startPage();
        List<JshAccountItem> list = jshAccountItemService.selectJshAccountItemList(jshAccountItem);
        return getDataTable(list);
    }

    /**
     * 导出财务子列表
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:export')")
    @Log(title = "财务子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshAccountItem jshAccountItem)
    {
        List<JshAccountItem> list = jshAccountItemService.selectJshAccountItemList(jshAccountItem);
        ExcelUtil<JshAccountItem> util = new ExcelUtil<JshAccountItem>(JshAccountItem.class);
        util.exportExcel(response, list, "财务子数据");
    }

    /**
     * 获取财务子详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshAccountItemService.selectJshAccountItemById(id));
    }

    /**
     * 新增财务子
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:add')")
    @Log(title = "财务子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshAccountItem jshAccountItem)
    {
        return toAjax(jshAccountItemService.insertJshAccountItem(jshAccountItem));
    }

    /**
     * 修改财务子
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:edit')")
    @Log(title = "财务子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshAccountItem jshAccountItem)
    {
        return toAjax(jshAccountItemService.updateJshAccountItem(jshAccountItem));
    }

    /**
     * 删除财务子
     */
    @PreAuthorize("@ss.hasPermi('erp:act_item:remove')")
    @Log(title = "财务子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshAccountItemService.deleteJshAccountItemByIds(ids));
    }
}
