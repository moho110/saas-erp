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
import com.vrmlstudio.erp.domain.JshDepot;
import com.vrmlstudio.erp.service.IJshDepotService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 仓库Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/depot")
public class JshDepotController extends BaseController
{
    @Autowired
    private IJshDepotService jshDepotService;

    /**
     * 查询仓库列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshDepot jshDepot)
    {
        startPage();
        List<JshDepot> list = jshDepotService.selectJshDepotList(jshDepot);
        return getDataTable(list);
    }

    /**
     * 导出仓库列表
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:export')")
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshDepot jshDepot)
    {
        List<JshDepot> list = jshDepotService.selectJshDepotList(jshDepot);
        ExcelUtil<JshDepot> util = new ExcelUtil<JshDepot>(JshDepot.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshDepotService.selectJshDepotById(id));
    }

    /**
     * 新增仓库
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:add')")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshDepot jshDepot)
    {
        return toAjax(jshDepotService.insertJshDepot(jshDepot));
    }

    /**
     * 修改仓库
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:edit')")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshDepot jshDepot)
    {
        return toAjax(jshDepotService.updateJshDepot(jshDepot));
    }

    /**
     * 删除仓库
     */
    @PreAuthorize("@ss.hasPermi('erp:depot:remove')")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshDepotService.deleteJshDepotByIds(ids));
    }
}
