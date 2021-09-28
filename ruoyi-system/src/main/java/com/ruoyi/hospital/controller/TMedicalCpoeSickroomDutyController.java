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
import com.ruoyi.hospital.domain.TMedicalCpoeSickroomDuty;
import com.ruoyi.hospital.service.ITMedicalCpoeSickroomDutyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病房值班记录Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/hospital/duty")
public class TMedicalCpoeSickroomDutyController extends BaseController
{
    @Autowired
    private ITMedicalCpoeSickroomDutyService tMedicalCpoeSickroomDutyService;

    /**
     * 查询病房值班记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        startPage();
        List<TMedicalCpoeSickroomDuty> list = tMedicalCpoeSickroomDutyService.selectTMedicalCpoeSickroomDutyList(tMedicalCpoeSickroomDuty);
        return getDataTable(list);
    }

    /**
     * 导出病房值班记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:export')")
    @Log(title = "病房值班记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        List<TMedicalCpoeSickroomDuty> list = tMedicalCpoeSickroomDutyService.selectTMedicalCpoeSickroomDutyList(tMedicalCpoeSickroomDuty);
        ExcelUtil<TMedicalCpoeSickroomDuty> util = new ExcelUtil<TMedicalCpoeSickroomDuty>(TMedicalCpoeSickroomDuty.class);
        return util.exportExcel(list, "病房值班记录数据");
    }

    /**
     * 获取病房值班记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoeSickroomDutyService.selectTMedicalCpoeSickroomDutyById(id));
    }

    /**
     * 新增病房值班记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:add')")
    @Log(title = "病房值班记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        return toAjax(tMedicalCpoeSickroomDutyService.insertTMedicalCpoeSickroomDuty(tMedicalCpoeSickroomDuty));
    }

    /**
     * 修改病房值班记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:edit')")
    @Log(title = "病房值班记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        return toAjax(tMedicalCpoeSickroomDutyService.updateTMedicalCpoeSickroomDuty(tMedicalCpoeSickroomDuty));
    }

    /**
     * 删除病房值班记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:remove')")
    @Log(title = "病房值班记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoeSickroomDutyService.deleteTMedicalCpoeSickroomDutyByIds(ids));
    }
}
