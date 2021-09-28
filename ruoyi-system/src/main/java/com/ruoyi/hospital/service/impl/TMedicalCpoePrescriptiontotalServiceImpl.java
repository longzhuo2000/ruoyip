package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoePrescriptiontotalMapper;
import com.ruoyi.hospital.domain.TMedicalCpoePrescriptiontotal;
import com.ruoyi.hospital.service.ITMedicalCpoePrescriptiontotalService;

/**
 * 住院治疗处方总Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoePrescriptiontotalServiceImpl implements ITMedicalCpoePrescriptiontotalService 
{
    @Autowired
    private TMedicalCpoePrescriptiontotalMapper tMedicalCpoePrescriptiontotalMapper;

    /**
     * 查询住院治疗处方总
     * 
     * @param id 住院治疗处方总主键
     * @return 住院治疗处方总
     */
    @Override
    public TMedicalCpoePrescriptiontotal selectTMedicalCpoePrescriptiontotalById(String id)
    {
        return tMedicalCpoePrescriptiontotalMapper.selectTMedicalCpoePrescriptiontotalById(id);
    }

    /**
     * 查询住院治疗处方总列表
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 住院治疗处方总
     */
    @Override
    public List<TMedicalCpoePrescriptiontotal> selectTMedicalCpoePrescriptiontotalList(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        return tMedicalCpoePrescriptiontotalMapper.selectTMedicalCpoePrescriptiontotalList(tMedicalCpoePrescriptiontotal);
    }

    /**
     * 新增住院治疗处方总
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoePrescriptiontotal(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        return tMedicalCpoePrescriptiontotalMapper.insertTMedicalCpoePrescriptiontotal(tMedicalCpoePrescriptiontotal);
    }

    /**
     * 修改住院治疗处方总
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoePrescriptiontotal(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal)
    {
        return tMedicalCpoePrescriptiontotalMapper.updateTMedicalCpoePrescriptiontotal(tMedicalCpoePrescriptiontotal);
    }

    /**
     * 批量删除住院治疗处方总
     * 
     * @param ids 需要删除的住院治疗处方总主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoePrescriptiontotalByIds(String[] ids)
    {
        return tMedicalCpoePrescriptiontotalMapper.deleteTMedicalCpoePrescriptiontotalByIds(ids);
    }

    /**
     * 删除住院治疗处方总信息
     * 
     * @param id 住院治疗处方总主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoePrescriptiontotalById(String id)
    {
        return tMedicalCpoePrescriptiontotalMapper.deleteTMedicalCpoePrescriptiontotalById(id);
    }
}
