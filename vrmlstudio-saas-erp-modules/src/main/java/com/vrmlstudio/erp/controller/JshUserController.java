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
import com.vrmlstudio.erp.domain.JshUser;
import com.vrmlstudio.erp.service.IJshUserService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/user")
public class JshUserController extends BaseController
{
    @Autowired
    private IJshUserService jshUserService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('erp:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshUser jshUser)
    {
        startPage();
        List<JshUser> list = jshUserService.selectJshUserList(jshUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('erp:user:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshUser jshUser)
    {
        List<JshUser> list = jshUserService.selectJshUserList(jshUser);
        ExcelUtil<JshUser> util = new ExcelUtil<JshUser>(JshUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshUserService.selectJshUserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('erp:user:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshUser jshUser)
    {
        return toAjax(jshUserService.insertJshUser(jshUser));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('erp:user:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshUser jshUser)
    {
        return toAjax(jshUserService.updateJshUser(jshUser));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('erp:user:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshUserService.deleteJshUserByIds(ids));
    }
}
