package com.ruoyi.drug.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.drug.domain.TMedicalDrugsInventoryRecord;
import com.ruoyi.drug.domain.TMedicalDrugsStorage;
import com.ruoyi.drug.domain.dto.PharmacyiInventoryDto;
import com.ruoyi.drug.service.ITMedicalDrugsInventoryRecordService;
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
import com.ruoyi.drug.domain.TMedicalDrugsPurchase;
import com.ruoyi.drug.service.ITMedicalDrugsPurchaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品采购信息Controller
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@RestController
@RequestMapping("/drug/purchase")
public class TMedicalDrugsPurchaseController extends BaseController
{
    @Autowired
    private ITMedicalDrugsPurchaseService tMedicalDrugsPurchaseService;
//    @Autowired
//    private ITMedicalDrugsInventoryRecordService inventoryRecordService;

    /**
     * 查询药品采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        startPage();
        List<TMedicalDrugsPurchase> list = tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseList(tMedicalDrugsPurchase);
        return getDataTable(list);
    }

    /**
     * 导出药品采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:export')")
    @Log(title = "药品采购信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        List<TMedicalDrugsPurchase> list = tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseList(tMedicalDrugsPurchase);
        ExcelUtil<TMedicalDrugsPurchase> util = new ExcelUtil<TMedicalDrugsPurchase>(TMedicalDrugsPurchase.class);
        return util.exportExcel(list, "药品采购信息数据");
    }

    /**
     * 获取药品采购信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalDrugsPurchaseService.selectTMedicalDrugsPurchaseById(id));
    }

    /**
     * 新增药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:add')")
    @Log(title = "药品采购信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalDrugsPurchase tMedicalDrugsStorage)
    {
        //采购药品
//        TMedicalDrugsPurchase purchase = dto.getPurchase();
        //盘点
//        TMedicalDrugsInventoryRecord record = dto.getRecord();
//        String purId= SecurityUtils.getUsername()+new Date().getTime();
//        purchase.setId(purId);

          tMedicalDrugsStorage.setId(SecurityUtils.getUsername()+new Date().getTime());
          int i = tMedicalDrugsPurchaseService.insertTMedicalDrugsPurchase(tMedicalDrugsStorage);
//        record.setId(SecurityUtils.getUsername()+new Date().getTime());
//        record.setDrugsid(purchase.getDrugsid());
//        record.setPapernumber(purchase.getNo());
//        i=inventoryRecordService.insertTMedicalDrugsInventoryRecord(record);
        return toAjax(i);
    }

    /**
     * 修改药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:edit')")
    @Log(title = "药品采购信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalDrugsPurchase tMedicalDrugsPurchase)
    {
        return toAjax(tMedicalDrugsPurchaseService.updateTMedicalDrugsPurchase(tMedicalDrugsPurchase));
    }

    /**
     * 删除药品采购信息
     */
    @PreAuthorize("@ss.hasPermi('drug:purchase:remove')")
    @Log(title = "药品采购信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalDrugsPurchaseService.deleteTMedicalDrugsPurchaseByIds(ids));
    }
}
