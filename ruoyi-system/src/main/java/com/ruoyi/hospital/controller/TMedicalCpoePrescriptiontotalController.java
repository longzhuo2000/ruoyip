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
import com.ruoyi.hospital.domain.TMedicalCpoePrescriptiontotal;
import com.ruoyi.hospital.service.ITMedicalCpoePrescriptiontotalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 住院治疗处方总Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/hospital/prescriptiontotal")
public class TMedicalCpoePrescriptiontotalController extends BaseController
{
    @Autowired
    private ITMedicalCpoePrescriptiontotalService tMedicalCpoePrescriptiontotalService;

    /**
     * 查询住院治疗处方总列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        startPage();
        List<TMedicalCpoePrescriptiontotal> list = tMedicalCpoePrescriptiontotalService.selectTMedicalCpoePrescriptiontotalList(tMedicalCpoePrescriptiontotal);
        return getDataTable(list);
    }

    /**
     * 导出住院治疗处方总列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:export')")
    @Log(title = "住院治疗处方总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        List<TMedicalCpoePrescriptiontotal> list = tMedicalCpoePrescriptiontotalService.selectTMedicalCpoePrescriptiontotalList(tMedicalCpoePrescriptiontotal);
        ExcelUtil<TMedicalCpoePrescriptiontotal> util = new ExcelUtil<TMedicalCpoePrescriptiontotal>(TMedicalCpoePrescriptiontotal.class);
        return util.exportExcel(list, "住院治疗处方总数据");
    }

    /**
     * 获取住院治疗处方总详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCpoePrescriptiontotalService.selectTMedicalCpoePrescriptiontotalById(id));
    }

    /**
     * 新增住院治疗处方总
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:add')")
    @Log(title = "住院治疗处方总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        return toAjax(tMedicalCpoePrescriptiontotalService.insertTMedicalCpoePrescriptiontotal(tMedicalCpoePrescriptiontotal));
    }

    /**
     * 修改住院治疗处方总
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:edit')")
    @Log(title = "住院治疗处方总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        return toAjax(tMedicalCpoePrescriptiontotalService.updateTMedicalCpoePrescriptiontotal(tMedicalCpoePrescriptiontotal));
    }

    /**
     * 删除住院治疗处方总
     */
    @PreAuthorize("@ss.hasPermi('hospital:prescriptiontotal:remove')")
    @Log(title = "住院治疗处方总", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCpoePrescriptiontotalService.deleteTMedicalCpoePrescriptiontotalByIds(ids));
    }
}
