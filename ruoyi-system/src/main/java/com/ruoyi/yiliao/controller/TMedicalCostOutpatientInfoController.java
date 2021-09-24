package com.ruoyi.yiliao.controller;

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
import com.ruoyi.yiliao.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.yiliao.service.ITMedicalCostOutpatientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门诊卡信息Controller
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@RestController
@RequestMapping("/yiliao/info")
public class TMedicalCostOutpatientInfoController extends BaseController
{
    @Autowired
    private ITMedicalCostOutpatientInfoService tMedicalCostOutpatientInfoService;

    /**
     * 查询门诊卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        startPage();
        List<TMedicalCostOutpatientInfo> list = tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
        return getDataTable(list);
    }

    /**
     * 导出门诊卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:export')")
    @Log(title = "门诊卡信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        List<TMedicalCostOutpatientInfo> list = tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
        ExcelUtil<TMedicalCostOutpatientInfo> util = new ExcelUtil<TMedicalCostOutpatientInfo>(TMedicalCostOutpatientInfo.class);
        return util.exportExcel(list, "门诊卡信息数据");
    }

    /**
     * 获取门诊卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tMedicalCostOutpatientInfoService.selectTMedicalCostOutpatientInfoById(id));
    }

    /**
     * 新增门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:add')")
    @Log(title = "门诊卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return toAjax(tMedicalCostOutpatientInfoService.insertTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo));
    }

    /**
     * 修改门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:edit')")
    @Log(title = "门诊卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return toAjax(tMedicalCostOutpatientInfoService.updateTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo));
    }

    /**
     * 删除门诊卡信息
     */
    @PreAuthorize("@ss.hasPermi('yiliao:info:remove')")
    @Log(title = "门诊卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMedicalCostOutpatientInfoService.deleteTMedicalCostOutpatientInfoByIds(ids));
    }
}
