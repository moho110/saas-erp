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
import com.vrmlstudio.erp.domain.JshRole;
import com.vrmlstudio.erp.service.IJshRoleService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 角色Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/role")
public class JshRoleController extends BaseController
{
    @Autowired
    private IJshRoleService jshRoleService;

    /**
     * 查询角色列表
     */
    @PreAuthorize("@ss.hasPermi('erp:role:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshRole jshRole)
    {
        startPage();
        List<JshRole> list = jshRoleService.selectJshRoleList(jshRole);
        return getDataTable(list);
    }

    /**
     * 导出角色列表
     */
    @PreAuthorize("@ss.hasPermi('erp:role:export')")
    @Log(title = "角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshRole jshRole)
    {
        List<JshRole> list = jshRoleService.selectJshRoleList(jshRole);
        ExcelUtil<JshRole> util = new ExcelUtil<JshRole>(JshRole.class);
        util.exportExcel(response, list, "角色数据");
    }

    /**
     * 获取角色详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:role:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshRoleService.selectJshRoleById(id));
    }

    /**
     * 新增角色
     */
    @PreAuthorize("@ss.hasPermi('erp:role:add')")
    @Log(title = "角色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshRole jshRole)
    {
        return toAjax(jshRoleService.insertJshRole(jshRole));
    }

    /**
     * 修改角色
     */
    @PreAuthorize("@ss.hasPermi('erp:role:edit')")
    @Log(title = "角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshRole jshRole)
    {
        return toAjax(jshRoleService.updateJshRole(jshRole));
    }

    /**
     * 删除角色
     */
    @PreAuthorize("@ss.hasPermi('erp:role:remove')")
    @Log(title = "角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshRoleService.deleteJshRoleByIds(ids));
    }
}
