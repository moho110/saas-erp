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
import com.vrmlstudio.erp.domain.JshSystemConfig;
import com.vrmlstudio.erp.service.IJshSystemConfigService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 系统参数Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/sys_config")
public class JshSystemConfigController extends BaseController
{
    @Autowired
    private IJshSystemConfigService jshSystemConfigService;

    /**
     * 查询系统参数列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshSystemConfig jshSystemConfig)
    {
        startPage();
        List<JshSystemConfig> list = jshSystemConfigService.selectJshSystemConfigList(jshSystemConfig);
        return getDataTable(list);
    }

    /**
     * 导出系统参数列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:export')")
    @Log(title = "系统参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshSystemConfig jshSystemConfig)
    {
        List<JshSystemConfig> list = jshSystemConfigService.selectJshSystemConfigList(jshSystemConfig);
        ExcelUtil<JshSystemConfig> util = new ExcelUtil<JshSystemConfig>(JshSystemConfig.class);
        util.exportExcel(response, list, "系统参数数据");
    }

    /**
     * 获取系统参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshSystemConfigService.selectJshSystemConfigById(id));
    }

    /**
     * 新增系统参数
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:add')")
    @Log(title = "系统参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshSystemConfig jshSystemConfig)
    {
        return toAjax(jshSystemConfigService.insertJshSystemConfig(jshSystemConfig));
    }

    /**
     * 修改系统参数
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:edit')")
    @Log(title = "系统参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshSystemConfig jshSystemConfig)
    {
        return toAjax(jshSystemConfigService.updateJshSystemConfig(jshSystemConfig));
    }

    /**
     * 删除系统参数
     */
    @PreAuthorize("@ss.hasPermi('erp:sys_config:remove')")
    @Log(title = "系统参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshSystemConfigService.deleteJshSystemConfigByIds(ids));
    }
}
