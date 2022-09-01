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
import com.vrmlstudio.erp.domain.JshAccount;
import com.vrmlstudio.erp.service.IJshAccountService;
import com.vrmlstudio.common.utils.poi.ExcelUtil;
import com.vrmlstudio.common.core.page.TableDataInfo;

/**
 * 账户信息Controller
 * 
 * @author vrmlstudio
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/erp/account")
public class JshAccountController extends BaseController
{
    @Autowired
    private IJshAccountService jshAccountService;

    /**
     * 查询账户信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(JshAccount jshAccount)
    {
        startPage();
        List<JshAccount> list = jshAccountService.selectJshAccountList(jshAccount);
        return getDataTable(list);
    }

    /**
     * 导出账户信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:account:export')")
    @Log(title = "账户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JshAccount jshAccount)
    {
        List<JshAccount> list = jshAccountService.selectJshAccountList(jshAccount);
        ExcelUtil<JshAccount> util = new ExcelUtil<JshAccount>(JshAccount.class);
        util.exportExcel(response, list, "账户信息数据");
    }

    /**
     * 获取账户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jshAccountService.selectJshAccountById(id));
    }

    /**
     * 新增账户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:account:add')")
    @Log(title = "账户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JshAccount jshAccount)
    {
        return toAjax(jshAccountService.insertJshAccount(jshAccount));
    }

    /**
     * 修改账户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:account:edit')")
    @Log(title = "账户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JshAccount jshAccount)
    {
        return toAjax(jshAccountService.updateJshAccount(jshAccount));
    }

    /**
     * 删除账户信息
     */
    @PreAuthorize("@ss.hasPermi('erp:account:remove')")
    @Log(title = "账户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jshAccountService.deleteJshAccountByIds(ids));
    }
}
