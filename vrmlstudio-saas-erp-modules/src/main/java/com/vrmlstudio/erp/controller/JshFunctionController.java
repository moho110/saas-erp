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
import com.vrmlstudio.erp.domain.JshFunction;
import com.vrmlstudio.erp.service.IJshFunctionService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 功能模块Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/function")
public class JshFunctionController extends BaseController
{
    @Autowired
    private IJshFunctionService jshFunctionService;

    /**
     * 查询功能模块列表
     */
    @PreAuthorize("@ss.hasPermi('erp:function:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshFunction jshFunction)
    {
        startPage();
        List<JshFunction> list = jshFunctionService.selectJshFunctionList(jshFunction);
        return getDataTable(list);
    }

    /**
     * 导出功能模块列表
     */
    @PreAuthorize("@ss.hasPermi('erp:function:export')")
    @Log(title = "功能模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshFunction jshFunction)
    {
        List<JshFunction> list = jshFunctionService.selectJshFunctionList(jshFunction);
        ExcelUtil<JshFunction> util = new ExcelUtil<JshFunction>(JshFunction.class);
        util.exportExcel(response, list, "功能模块数据");
    }

    /**
     * 获取功能模块详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:function:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshFunctionService.selectJshFunctionById(id));
    }

    /**
     * 新增功能模块
     */
    @PreAuthorize("@ss.hasPermi('erp:function:add')")
    @Log(title = "功能模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshFunction jshFunction)
    {
        return toAjax(jshFunctionService.insertJshFunction(jshFunction));
    }

    /**
     * 修改功能模块
     */
    @PreAuthorize("@ss.hasPermi('erp:function:edit')")
    @Log(title = "功能模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshFunction jshFunction)
    {
        return toAjax(jshFunctionService.updateJshFunction(jshFunction));
    }

    /**
     * 删除功能模块
     */
    @PreAuthorize("@ss.hasPermi('erp:function:remove')")
    @Log(title = "功能模块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshFunctionService.deleteJshFunctionByIds(ids));
    }
}
