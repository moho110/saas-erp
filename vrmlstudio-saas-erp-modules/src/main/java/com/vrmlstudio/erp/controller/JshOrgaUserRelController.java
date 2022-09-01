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
import com.vrmlstudio.erp.domain.JshOrgaUserRel;
import com.vrmlstudio.erp.service.IJshOrgaUserRelService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 机构用户关系Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/orga_user_rel")
public class JshOrgaUserRelController extends BaseController
{
    @Autowired
    private IJshOrgaUserRelService jshOrgaUserRelService;

    /**
     * 查询机构用户关系列表
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshOrgaUserRel jshOrgaUserRel)
    {
        startPage();
        List<JshOrgaUserRel> list = jshOrgaUserRelService.selectJshOrgaUserRelList(jshOrgaUserRel);
        return getDataTable(list);
    }

    /**
     * 导出机构用户关系列表
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:export')")
    @Log(title = "机构用户关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshOrgaUserRel jshOrgaUserRel)
    {
        List<JshOrgaUserRel> list = jshOrgaUserRelService.selectJshOrgaUserRelList(jshOrgaUserRel);
        ExcelUtil<JshOrgaUserRel> util = new ExcelUtil<JshOrgaUserRel>(JshOrgaUserRel.class);
        util.exportExcel(response, list, "机构用户关系数据");
    }

    /**
     * 获取机构用户关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshOrgaUserRelService.selectJshOrgaUserRelById(id));
    }

    /**
     * 新增机构用户关系
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:add')")
    @Log(title = "机构用户关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshOrgaUserRel jshOrgaUserRel)
    {
        return toAjax(jshOrgaUserRelService.insertJshOrgaUserRel(jshOrgaUserRel));
    }

    /**
     * 修改机构用户关系
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:edit')")
    @Log(title = "机构用户关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshOrgaUserRel jshOrgaUserRel)
    {
        return toAjax(jshOrgaUserRelService.updateJshOrgaUserRel(jshOrgaUserRel));
    }

    /**
     * 删除机构用户关系
     */
    @PreAuthorize("@ss.hasPermi('erp:orga_user_rel:remove')")
    @Log(title = "机构用户关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshOrgaUserRelService.deleteJshOrgaUserRelByIds(ids));
    }
}
