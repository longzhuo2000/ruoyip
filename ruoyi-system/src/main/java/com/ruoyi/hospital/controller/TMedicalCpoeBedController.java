package com.ruoyi.hospital.controller;

import java.util.List;
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
import com.ruoyi.hospital.domain.TMedicalCpoeBed;
import com.ruoyi.hospital.service.ITMedicalCpoeBedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 床位记录Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/hospital/bed")
public class TMedicalCpoeBedController extends BaseController
{
    @Autowired
    private ITMedicalCpoeBedService tMedicalCpoeBedService;

    /**
     * 查询床位记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoeBed tMedicalCpoeBed)
    {
        startPage();
        List<TMedicalCpoeBed> list = tMedicalCpoeBedService.selectTMedicalCpoeBedList(tMedicalCpoeBed);
        return getDataTable(list);
    }

    /**
     * 导出床位记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:export')")
    @Log(title = "床位记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCpoeBed tMedicalCpoeBed)
    {
        List<TMedicalCpoeBed> list = tMedicalCpoeBedService.selectTMedicalCpoeBedList(tMedicalCpoeBed);
        ExcelUtil<TMedicalCpoeBed> util = new ExcelUtil<TMedicalCpoeBed>(TMedicalCpoeBed.class);
        return util.exportExcel(list, "床位记录数据");
    }

    /**
     * 获取床位记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoeBedService.selectTMedicalCpoeBedById(id));
    }

    /**
     * 新增床位记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:add')")
    @Log(title = "床位记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoeBed tMedicalCpoeBed)
    {
        return toAjax(tMedicalCpoeBedService.insertTMedicalCpoeBed(tMedicalCpoeBed));
    }

    /**
     * 修改床位记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:edit')")
    @Log(title = "床位记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoeBed tMedicalCpoeBed)
    {
        return toAjax(tMedicalCpoeBedService.updateTMedicalCpoeBed(tMedicalCpoeBed));
    }

    /**
     * 删除床位记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:bed:remove')")
    @Log(title = "床位记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoeBedService.deleteTMedicalCpoeBedByIds(ids));
    }
}
