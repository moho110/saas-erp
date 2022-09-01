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
import com.vrmlstudio.erp.domain.JshPerson;
import com.vrmlstudio.erp.service.IJshPersonService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 经手人Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/person")
public class JshPersonController extends BaseController
{
    @Autowired
    private IJshPersonService jshPersonService;

    /**
     * 查询经手人列表
     */
    @PreAuthorize("@ss.hasPermi('erp:person:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshPerson jshPerson)
    {
        startPage();
        List<JshPerson> list = jshPersonService.selectJshPersonList(jshPerson);
        return getDataTable(list);
    }

    /**
     * 导出经手人列表
     */
    @PreAuthorize("@ss.hasPermi('erp:person:export')")
    @Log(title = "经手人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshPerson jshPerson)
    {
        List<JshPerson> list = jshPersonService.selectJshPersonList(jshPerson);
        ExcelUtil<JshPerson> util = new ExcelUtil<JshPerson>(JshPerson.class);
        util.exportExcel(response, list, "经手人数据");
    }

    /**
     * 获取经手人详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:person:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshPersonService.selectJshPersonById(id));
    }

    /**
     * 新增经手人
     */
    @PreAuthorize("@ss.hasPermi('erp:person:add')")
    @Log(title = "经手人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshPerson jshPerson)
    {
        return toAjax(jshPersonService.insertJshPerson(jshPerson));
    }

    /**
     * 修改经手人
     */
    @PreAuthorize("@ss.hasPermi('erp:person:edit')")
    @Log(title = "经手人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshPerson jshPerson)
    {
        return toAjax(jshPersonService.updateJshPerson(jshPerson));
    }

    /**
     * 删除经手人
     */
    @PreAuthorize("@ss.hasPermi('erp:person:remove')")
    @Log(title = "经手人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshPersonService.deleteJshPersonByIds(ids));
    }
}
