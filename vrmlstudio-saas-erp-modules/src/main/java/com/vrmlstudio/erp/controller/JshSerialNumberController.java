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
import com.vrmlstudio.erp.domain.JshSerialNumber;
import com.vrmlstudio.erp.service.IJshSerialNumberService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 序列号Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/s_number")
public class JshSerialNumberController extends BaseController
{
    @Autowired
    private IJshSerialNumberService jshSerialNumberService;

    /**
     * 查询序列号列表
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshSerialNumber jshSerialNumber)
    {
        startPage();
        List<JshSerialNumber> list = jshSerialNumberService.selectJshSerialNumberList(jshSerialNumber);
        return getDataTable(list);
    }

    /**
     * 导出序列号列表
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:export')")
    @Log(title = "序列号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshSerialNumber jshSerialNumber)
    {
        List<JshSerialNumber> list = jshSerialNumberService.selectJshSerialNumberList(jshSerialNumber);
        ExcelUtil<JshSerialNumber> util = new ExcelUtil<JshSerialNumber>(JshSerialNumber.class);
        util.exportExcel(response, list, "序列号数据");
    }

    /**
     * 获取序列号详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshSerialNumberService.selectJshSerialNumberById(id));
    }

    /**
     * 新增序列号
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:add')")
    @Log(title = "序列号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshSerialNumber jshSerialNumber)
    {
        return toAjax(jshSerialNumberService.insertJshSerialNumber(jshSerialNumber));
    }

    /**
     * 修改序列号
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:edit')")
    @Log(title = "序列号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshSerialNumber jshSerialNumber)
    {
        return toAjax(jshSerialNumberService.updateJshSerialNumber(jshSerialNumber));
    }

    /**
     * 删除序列号
     */
    @PreAuthorize("@ss.hasPermi('erp:s_number:remove')")
    @Log(title = "序列号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshSerialNumberService.deleteJshSerialNumberByIds(ids));
    }
}
