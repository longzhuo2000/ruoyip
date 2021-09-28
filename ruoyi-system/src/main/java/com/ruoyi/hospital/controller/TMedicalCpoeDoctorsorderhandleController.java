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
import com.ruoyi.hospital.domain.TMedicalCpoeDoctorsorderhandle;
import com.ruoyi.hospital.service.ITMedicalCpoeDoctorsorderhandleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医嘱执行记录Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/hospital/doctorsorderhandle")
public class TMedicalCpoeDoctorsorderhandleController extends BaseController
{
    @Autowired
    private ITMedicalCpoeDoctorsorderhandleService tMedicalCpoeDoctorsorderhandleService;

    /**
     * 查询医嘱执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        startPage();
        List<TMedicalCpoeDoctorsorderhandle> list = tMedicalCpoeDoctorsorderhandleService.selectTMedicalCpoeDoctorsorderhandleList(tMedicalCpoeDoctorsorderhandle);
        return getDataTable(list);
    }

    /**
     * 导出医嘱执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:export')")
    @Log(title = "医嘱执行记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        List<TMedicalCpoeDoctorsorderhandle> list = tMedicalCpoeDoctorsorderhandleService.selectTMedicalCpoeDoctorsorderhandleList(tMedicalCpoeDoctorsorderhandle);
        ExcelUtil<TMedicalCpoeDoctorsorderhandle> util = new ExcelUtil<TMedicalCpoeDoctorsorderhandle>(TMedicalCpoeDoctorsorderhandle.class);
        return util.exportExcel(list, "医嘱执行记录数据");
    }

    /**
     * 获取医嘱执行记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoeDoctorsorderhandleService.selectTMedicalCpoeDoctorsorderhandleById(id));
    }

    /**
     * 新增医嘱执行记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:add')")
    @Log(title = "医嘱执行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        return toAjax(tMedicalCpoeDoctorsorderhandleService.insertTMedicalCpoeDoctorsorderhandle(tMedicalCpoeDoctorsorderhandle));
    }

    /**
     * 修改医嘱执行记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:edit')")
    @Log(title = "医嘱执行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        return toAjax(tMedicalCpoeDoctorsorderhandleService.updateTMedicalCpoeDoctorsorderhandle(tMedicalCpoeDoctorsorderhandle));
    }

    /**
     * 删除医嘱执行记录
     */
    @PreAuthorize("@ss.hasPermi('hospital:doctorsorderhandle:remove')")
    @Log(title = "医嘱执行记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoeDoctorsorderhandleService.deleteTMedicalCpoeDoctorsorderhandleByIds(ids));
    }
}
