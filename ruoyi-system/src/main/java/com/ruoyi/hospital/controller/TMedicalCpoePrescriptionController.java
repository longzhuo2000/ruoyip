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
import com.ruoyi.hospital.domain.TMedicalCpoePrescription;
import com.ruoyi.hospital.service.ITMedicalCpoePrescriptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 住院治疗处方Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/hospital/prescription")
public class TMedicalCpoePrescriptionController extends BaseController
{
    @Autowired
    private ITMedicalCpoePrescriptionService tMedicalCpoePrescriptionService;

    /**
     * 查询住院治疗处方列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        startPage();
        List<TMedicalCpoePrescription> list = tMedicalCpoePrescriptionService.selectTMedicalCpoePrescriptionList(tMedicalCpoePrescription);
        return getDataTable(list);
    }

    /**
     * 导出住院治疗处方列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:export')")
    @Log(title = "住院治疗处方", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        List<TMedicalCpoePrescription> list = tMedicalCpoePrescriptionService.selectTMedicalCpoePrescriptionList(tMedicalCpoePrescription);
        ExcelUtil<TMedicalCpoePrescription> util = new ExcelUtil<TMedicalCpoePrescription>(TMedicalCpoePrescription.class);
        return util.exportExcel(list, "住院治疗处方数据");
    }

    /**
     * 获取住院治疗处方详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoePrescriptionService.selectTMedicalCpoePrescriptionById(id));
    }

    /**
     * 新增住院治疗处方
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:add')")
    @Log(title = "住院治疗处方", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        return toAjax(tMedicalCpoePrescriptionService.insertTMedicalCpoePrescription(tMedicalCpoePrescription));
    }

    /**
     * 修改住院治疗处方
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:edit')")
    @Log(title = "住院治疗处方", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        return toAjax(tMedicalCpoePrescriptionService.updateTMedicalCpoePrescription(tMedicalCpoePrescription));
    }

    /**
     * 删除住院治疗处方
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescription:remove')")
    @Log(title = "住院治疗处方", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoePrescriptionService.deleteTMedicalCpoePrescriptionByIds(ids));
    }
}
