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
import com.vrmlstudio.erp.domain.JshMsg;
import com.vrmlstudio.erp.service.IJshMsgService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 消息Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/msg")
public class JshMsgController extends BaseController
{
    @Autowired
    private IJshMsgService jshMsgService;

    /**
     * 查询消息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshMsg jshMsg)
    {
        startPage();
        List<JshMsg> list = jshMsgService.selectJshMsgList(jshMsg);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshMsg jshMsg)
    {
        List<JshMsg> list = jshMsgService.selectJshMsgList(jshMsg);
        ExcelUtil<JshMsg> util = new ExcelUtil<JshMsg>(JshMsg.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshMsgService.selectJshMsgById(id));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshMsg jshMsg)
    {
        return toAjax(jshMsgService.insertJshMsg(jshMsg));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshMsg jshMsg)
    {
        return toAjax(jshMsgService.updateJshMsg(jshMsg));
    }

    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('erp:msg:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshMsgService.deleteJshMsgByIds(ids));
    }
}
