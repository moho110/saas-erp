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
import com.vrmlstudio.erp.domain.JshUserBusiness;
import com.vrmlstudio.erp.service.IJshUserBusinessService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 用户/角色/模块关系Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/user_business")
public class JshUserBusinessController extends BaseController
{
    @Autowired
    private IJshUserBusinessService jshUserBusinessService;

    /**
     * 查询用户/角色/模块关系列表
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshUserBusiness jshUserBusiness)
    {
        startPage();
        List<JshUserBusiness> list = jshUserBusinessService.selectJshUserBusinessList(jshUserBusiness);
        return getDataTable(list);
    }

    /**
     * 导出用户/角色/模块关系列表
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:export')")
    @Log(title = "用户/角色/模块关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshUserBusiness jshUserBusiness)
    {
        List<JshUserBusiness> list = jshUserBusinessService.selectJshUserBusinessList(jshUserBusiness);
        ExcelUtil<JshUserBusiness> util = new ExcelUtil<JshUserBusiness>(JshUserBusiness.class);
        util.exportExcel(response, list, "用户/角色/模块关系数据");
    }

    /**
     * 获取用户/角色/模块关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshUserBusinessService.selectJshUserBusinessById(id));
    }

    /**
     * 新增用户/角色/模块关系
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:add')")
    @Log(title = "用户/角色/模块关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshUserBusiness jshUserBusiness)
    {
        return toAjax(jshUserBusinessService.insertJshUserBusiness(jshUserBusiness));
    }

    /**
     * 修改用户/角色/模块关系
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:edit')")
    @Log(title = "用户/角色/模块关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshUserBusiness jshUserBusiness)
    {
        return toAjax(jshUserBusinessService.updateJshUserBusiness(jshUserBusiness));
    }

    /**
     * 删除用户/角色/模块关系
     */
    @PreAuthorize("@ss.hasPermi('erp:user_business:remove')")
    @Log(title = "用户/角色/模块关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshUserBusinessService.deleteJshUserBusinessByIds(ids));
    }
}
