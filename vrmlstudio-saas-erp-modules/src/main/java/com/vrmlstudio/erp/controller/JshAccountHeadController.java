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
import com.vrmlstudio.erp.domain.JshAccountHead;
import com.vrmlstudio.erp.service.IJshAccountHeadService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 财务主Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/acount_head")
public class JshAccountHeadController extends BaseController
{
    @Autowired
    private IJshAccountHeadService jshAccountHeadService;

    /**
     * 查询财务主列表
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshAccountHead jshAccountHead)
    {
        startPage();
        List<JshAccountHead> list = jshAccountHeadService.selectJshAccountHeadList(jshAccountHead);
        return getDataTable(list);
    }

    /**
     * 导出财务主列表
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:export')")
    @Log(title = "财务主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshAccountHead jshAccountHead)
    {
        List<JshAccountHead> list = jshAccountHeadService.selectJshAccountHeadList(jshAccountHead);
        ExcelUtil<JshAccountHead> util = new ExcelUtil<JshAccountHead>(JshAccountHead.class);
        util.exportExcel(response, list, "财务主数据");
    }

    /**
     * 获取财务主详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshAccountHeadService.selectJshAccountHeadById(id));
    }

    /**
     * 新增财务主
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:add')")
    @Log(title = "财务主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshAccountHead jshAccountHead)
    {
        return toAjax(jshAccountHeadService.insertJshAccountHead(jshAccountHead));
    }

    /**
     * 修改财务主
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:edit')")
    @Log(title = "财务主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshAccountHead jshAccountHead)
    {
        return toAjax(jshAccountHeadService.updateJshAccountHead(jshAccountHead));
    }

    /**
     * 删除财务主
     */
    @PreAuthorize("@ss.hasPermi('erp:acount_head:remove')")
    @Log(title = "财务主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshAccountHeadService.deleteJshAccountHeadByIds(ids));
    }
}
