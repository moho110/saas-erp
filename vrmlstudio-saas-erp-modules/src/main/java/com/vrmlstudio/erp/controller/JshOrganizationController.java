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
import com.vrmlstudio.erp.domain.JshOrganization;
import com.vrmlstudio.erp.service.IJshOrganizationService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;

/**
 * 机构Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/organization")
public class JshOrganizationController extends BaseController
{
    @Autowired
    private IJshOrganizationService jshOrganizationService;

    /**
     * 查询机构列表
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:list')")
    @GetMapping("/list")
    public AjaxResult list(JshOrganization jshOrganization)
    {
        List<JshOrganization> list = jshOrganizationService.selectJshOrganizationList(jshOrganization);
        return AjaxResult.success(list);
    }

    /**
     * 导出机构列表
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:export')")
    @Log(title = "机构", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshOrganization jshOrganization)
    {
        List<JshOrganization> list = jshOrganizationService.selectJshOrganizationList(jshOrganization);
        ExcelUtil<JshOrganization> util = new ExcelUtil<JshOrganization>(JshOrganization.class);
        util.exportExcel(response, list, "机构数据");
    }

    /**
     * 获取机构详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshOrganizationService.selectJshOrganizationById(id));
    }

    /**
     * 新增机构
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:add')")
    @Log(title = "机构", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshOrganization jshOrganization)
    {
        return toAjax(jshOrganizationService.insertJshOrganization(jshOrganization));
    }

    /**
     * 修改机构
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:edit')")
    @Log(title = "机构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshOrganization jshOrganization)
    {
        return toAjax(jshOrganizationService.updateJshOrganization(jshOrganization));
    }

    /**
     * 删除机构
     */
    @PreAuthorize("@ss.hasPermi('erp:organization:remove')")
    @Log(title = "机构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshOrganizationService.deleteJshOrganizationByIds(ids));
    }
}
