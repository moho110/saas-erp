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
import com.vrmlstudio.erp.domain.JshLog;
import com.vrmlstudio.erp.service.IJshLogService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 操作日志Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/log")
public class JshLogController extends BaseController
{
    @Autowired
    private IJshLogService jshLogService;

    /**
     * 查询操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('erp:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshLog jshLog)
    {
        startPage();
        List<JshLog> list = jshLogService.selectJshLogList(jshLog);
        return getDataTable(list);
    }

    /**
     * 导出操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('erp:log:export')")
    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshLog jshLog)
    {
        List<JshLog> list = jshLogService.selectJshLogList(jshLog);
        ExcelUtil<JshLog> util = new ExcelUtil<JshLog>(JshLog.class);
        util.exportExcel(response, list, "操作日志数据");
    }

    /**
     * 获取操作日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshLogService.selectJshLogById(id));
    }

    /**
     * 新增操作日志
     */
    @PreAuthorize("@ss.hasPermi('erp:log:add')")
    @Log(title = "操作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshLog jshLog)
    {
        return toAjax(jshLogService.insertJshLog(jshLog));
    }

    /**
     * 修改操作日志
     */
    @PreAuthorize("@ss.hasPermi('erp:log:edit')")
    @Log(title = "操作日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshLog jshLog)
    {
        return toAjax(jshLogService.updateJshLog(jshLog));
    }

    /**
     * 删除操作日志
     */
    @PreAuthorize("@ss.hasPermi('erp:log:remove')")
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshLogService.deleteJshLogByIds(ids));
    }
}
