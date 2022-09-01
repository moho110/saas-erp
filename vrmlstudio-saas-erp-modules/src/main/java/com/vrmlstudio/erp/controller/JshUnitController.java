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
import com.vrmlstudio.erp.domain.JshUnit;
import com.vrmlstudio.erp.service.IJshUnitService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 多单位Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/unit")
public class JshUnitController extends BaseController
{
    @Autowired
    private IJshUnitService jshUnitService;

    /**
     * 查询多单位列表
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshUnit jshUnit)
    {
        startPage();
        List<JshUnit> list = jshUnitService.selectJshUnitList(jshUnit);
        return getDataTable(list);
    }

    /**
     * 导出多单位列表
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:export')")
    @Log(title = "多单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshUnit jshUnit)
    {
        List<JshUnit> list = jshUnitService.selectJshUnitList(jshUnit);
        ExcelUtil<JshUnit> util = new ExcelUtil<JshUnit>(JshUnit.class);
        util.exportExcel(response, list, "多单位数据");
    }

    /**
     * 获取多单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshUnitService.selectJshUnitById(id));
    }

    /**
     * 新增多单位
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:add')")
    @Log(title = "多单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshUnit jshUnit)
    {
        return toAjax(jshUnitService.insertJshUnit(jshUnit));
    }

    /**
     * 修改多单位
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:edit')")
    @Log(title = "多单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshUnit jshUnit)
    {
        return toAjax(jshUnitService.updateJshUnit(jshUnit));
    }

    /**
     * 删除多单位
     */
    @PreAuthorize("@ss.hasPermi('erp:unit:remove')")
    @Log(title = "多单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshUnitService.deleteJshUnitByIds(ids));
    }
}
