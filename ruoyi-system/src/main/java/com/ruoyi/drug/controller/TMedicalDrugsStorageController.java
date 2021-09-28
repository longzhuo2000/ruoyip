package com.ruoyi.drug.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.drug.domain.TMedicalDrugsStorage;
import com.ruoyi.drug.service.ITMedicalDrugsStorageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药库库存Controller
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@RestController
@RequestMapping("/drug/storage")
public class TMedicalDrugsStorageController extends BaseController
{
    @Autowired
    private ITMedicalDrugsStorageService tMedicalDrugsStorageService;

    /**
     * 查询药库库存列表
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        startPage();
        List<TMedicalDrugsStorage> list = tMedicalDrugsStorageService.selectTMedicalDrugsStorageList(tMedicalDrugsStorage);
        return getDataTable(list);
    }

    /**
     * 导出药库库存列表
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:export')")
    @Log(title = "药库库存", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        List<TMedicalDrugsStorage> list = tMedicalDrugsStorageService.selectTMedicalDrugsStorageList(tMedicalDrugsStorage);
        ExcelUtil<TMedicalDrugsStorage> util = new ExcelUtil<TMedicalDrugsStorage>(TMedicalDrugsStorage.class);
        return util.exportExcel(list, "药库库存数据");
    }

    /**
     * 获取药库库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsStorageService.selectTMedicalDrugsStorageById(id));
    }

    /**
     * 新增药库库存
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:add')")
    @Log(title = "药库库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        tMedicalDrugsStorage.setId(SecurityUtils.getUsername()+new Date().getTime());
        return toAjax(tMedicalDrugsStorageService.insertTMedicalDrugsStorage(tMedicalDrugsStorage));
    }

    /**
     * 修改药库库存
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:edit')")
    @Log(title = "药库库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        return toAjax(tMedicalDrugsStorageService.updateTMedicalDrugsStorage(tMedicalDrugsStorage));
    }

    /**
     * 删除药库库存
     */
    @PreAuthorize("@ss.hasPermi('drug:storage:remove')")
    @Log(title = "药库库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsStorageService.deleteTMedicalDrugsStorageByIds(ids));
    }
}
