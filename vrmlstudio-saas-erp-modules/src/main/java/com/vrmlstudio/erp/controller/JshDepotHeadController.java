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
import com.vrmlstudio.erp.domain.JshDepotHead;
import com.vrmlstudio.erp.service.IJshDepotHeadService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 单据主Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/depot_head")
public class JshDepotHeadController extends BaseController
{
    @Autowired
    private IJshDepotHeadService jshDepotHeadService;

    /**
     * 查询单据主列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshDepotHead jshDepotHead)
    {
        startPage();
        List<JshDepotHead> list = jshDepotHeadService.selectJshDepotHeadList(jshDepotHead);
        return getDataTable(list);
    }

    /**
     * 导出单据主列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:export')")
    @Log(title = "单据主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshDepotHead jshDepotHead)
    {
        List<JshDepotHead> list = jshDepotHeadService.selectJshDepotHeadList(jshDepotHead);
        ExcelUtil<JshDepotHead> util = new ExcelUtil<JshDepotHead>(JshDepotHead.class);
        util.exportExcel(response, list, "单据主数据");
    }

    /**
     * 获取单据主详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshDepotHeadService.selectJshDepotHeadById(id));
    }

    /**
     * 新增单据主
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:add')")
    @Log(title = "单据主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshDepotHead jshDepotHead)
    {
        return toAjax(jshDepotHeadService.insertJshDepotHead(jshDepotHead));
    }

    /**
     * 修改单据主
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:edit')")
    @Log(title = "单据主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshDepotHead jshDepotHead)
    {
        return toAjax(jshDepotHeadService.updateJshDepotHead(jshDepotHead));
    }

    /**
     * 删除单据主
     */
    @PreAuthorize("@ss.hasPermi('erp:depot_head:remove')")
    @Log(title = "单据主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshDepotHeadService.deleteJshDepotHeadByIds(ids));
    }
}
