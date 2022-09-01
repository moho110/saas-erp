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
import com.vrmlstudio.erp.domain.JshPlatformConfig;
import com.vrmlstudio.erp.service.IJshPlatformConfigService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 平台参数Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/p_config")
public class JshPlatformConfigController extends BaseController
{
    @Autowired
    private IJshPlatformConfigService jshPlatformConfigService;

    /**
     * 查询平台参数列表
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshPlatformConfig jshPlatformConfig)
    {
        startPage();
        List<JshPlatformConfig> list = jshPlatformConfigService.selectJshPlatformConfigList(jshPlatformConfig);
        return getDataTable(list);
    }

    /**
     * 导出平台参数列表
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:export')")
    @Log(title = "平台参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshPlatformConfig jshPlatformConfig)
    {
        List<JshPlatformConfig> list = jshPlatformConfigService.selectJshPlatformConfigList(jshPlatformConfig);
        ExcelUtil<JshPlatformConfig> util = new ExcelUtil<JshPlatformConfig>(JshPlatformConfig.class);
        util.exportExcel(response, list, "平台参数数据");
    }

    /**
     * 获取平台参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshPlatformConfigService.selectJshPlatformConfigById(id));
    }

    /**
     * 新增平台参数
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:add')")
    @Log(title = "平台参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshPlatformConfig jshPlatformConfig)
    {
        return toAjax(jshPlatformConfigService.insertJshPlatformConfig(jshPlatformConfig));
    }

    /**
     * 修改平台参数
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:edit')")
    @Log(title = "平台参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshPlatformConfig jshPlatformConfig)
    {
        return toAjax(jshPlatformConfigService.updateJshPlatformConfig(jshPlatformConfig));
    }

    /**
     * 删除平台参数
     */
    @PreAuthorize("@ss.hasPermi('erp:p_config:remove')")
    @Log(title = "平台参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshPlatformConfigService.deleteJshPlatformConfigByIds(ids));
    }
}
