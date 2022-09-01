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
import com.vrmlstudio.erp.domain.JshSequence;
import com.vrmlstudio.erp.service.IJshSequenceService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 单据编号Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/sequence")
public class JshSequenceController extends BaseController
{
    @Autowired
    private IJshSequenceService jshSequenceService;

    /**
     * 查询单据编号列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshSequence jshSequence)
    {
        startPage();
        List<JshSequence> list = jshSequenceService.selectJshSequenceList(jshSequence);
        return getDataTable(list);
    }

    /**
     * 导出单据编号列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:export')")
    @Log(title = "单据编号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshSequence jshSequence)
    {
        List<JshSequence> list = jshSequenceService.selectJshSequenceList(jshSequence);
        ExcelUtil<JshSequence> util = new ExcelUtil<JshSequence>(JshSequence.class);
        util.exportExcel(response, list, "单据编号数据");
    }

    /**
     * 获取单据编号详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:query')")
    @GetMapping(value = "/{seqName}")
    public AjaxResult getInfo(@PathVariable("seqName") String seqName)
    {
        return AjaxResult.success(jshSequenceService.selectJshSequenceBySeqName(seqName));
    }

    /**
     * 新增单据编号
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:add')")
    @Log(title = "单据编号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshSequence jshSequence)
    {
        return toAjax(jshSequenceService.insertJshSequence(jshSequence));
    }

    /**
     * 修改单据编号
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:edit')")
    @Log(title = "单据编号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshSequence jshSequence)
    {
        return toAjax(jshSequenceService.updateJshSequence(jshSequence));
    }

    /**
     * 删除单据编号
     */
    @PreAuthorize("@ss.hasPermi('erp:sequence:remove')")
    @Log(title = "单据编号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{seqNames}")
    public AjaxResult remove(@PathVariable String[] seqNames)
    {
        return toAjax(jshSequenceService.deleteJshSequenceBySeqNames(seqNames));
    }
}
