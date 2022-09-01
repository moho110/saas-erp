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
import com.vrmlstudio.erp.domain.JshTenant;
import com.vrmlstudio.erp.service.IJshTenantService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 租户Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/tenant")
public class JshTenantController extends BaseController
{
    @Autowired
    private IJshTenantService jshTenantService;

    /**
     * 查询租户列表
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshTenant jshTenant)
    {
        startPage();
        List<JshTenant> list = jshTenantService.selectJshTenantList(jshTenant);
        return getDataTable(list);
    }

    /**
     * 导出租户列表
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:export')")
    @Log(title = "租户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshTenant jshTenant)
    {
        List<JshTenant> list = jshTenantService.selectJshTenantList(jshTenant);
        ExcelUtil<JshTenant> util = new ExcelUtil<JshTenant>(JshTenant.class);
        util.exportExcel(response, list, "租户数据");
    }

    /**
     * 获取租户详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshTenantService.selectJshTenantById(id));
    }

    /**
     * 新增租户
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:add')")
    @Log(title = "租户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshTenant jshTenant)
    {
        return toAjax(jshTenantService.insertJshTenant(jshTenant));
    }

    /**
     * 修改租户
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:edit')")
    @Log(title = "租户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshTenant jshTenant)
    {
        return toAjax(jshTenantService.updateJshTenant(jshTenant));
    }

    /**
     * 删除租户
     */
    @PreAuthorize("@ss.hasPermi('erp:tenant:remove')")
    @Log(title = "租户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshTenantService.deleteJshTenantByIds(ids));
    }
}
