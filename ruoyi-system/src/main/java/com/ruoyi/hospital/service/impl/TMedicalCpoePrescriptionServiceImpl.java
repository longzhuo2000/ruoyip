package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoePrescriptionMapper;
import com.ruoyi.hospital.domain.TMedicalCpoePrescription;
import com.ruoyi.hospital.service.ITMedicalCpoePrescriptionService;

/**
 * 住院治疗处方Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoePrescriptionServiceImpl implements ITMedicalCpoePrescriptionService 
{
    @Autowired
    private TMedicalCpoePrescriptionMapper tMedicalCpoePrescriptionMapper;

    /**
     * 查询住院治疗处方
     * 
     * @param id 住院治疗处方主键
     * @return 住院治疗处方
     */
    @Override
    public TMedicalCpoePrescription selectTMedicalCpoePrescriptionById(String id)
    {
        return tMedicalCpoePrescriptionMapper.selectTMedicalCpoePrescriptionById(id);
    }

    /**
     * 查询住院治疗处方列表
     * 
     * @param tMedicalCpoePrescription 住院治疗处方
     * @return 住院治疗处方
     */
    @Override
    public List<TMedicalCpoePrescription> selectTMedicalCpoePrescriptionList(TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        return tMedicalCpoePrescriptionMapper.selectTMedicalCpoePrescriptionList(tMedicalCpoePrescription);
    }

    /**
     * 新增住院治疗处方
     * 
     * @param tMedicalCpoePrescription 住院治疗处方
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoePrescription(TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        return tMedicalCpoePrescriptionMapper.insertTMedicalCpoePrescription(tMedicalCpoePrescription);
    }

    /**
     * 修改住院治疗处方
     * 
     * @param tMedicalCpoePrescription 住院治疗处方
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoePrescription(TMedicalCpoePrescription tMedicalCpoePrescription)
    {
        return tMedicalCpoePrescriptionMapper.updateTMedicalCpoePrescription(tMedicalCpoePrescription);
    }

    /**
     * 批量删除住院治疗处方
     * 
     * @param ids 需要删除的住院治疗处方主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoePrescriptionByIds(String[] ids)
    {
        return tMedicalCpoePrescriptionMapper.deleteTMedicalCpoePrescriptionByIds(ids);
    }

    /**
     * 删除住院治疗处方信息
     * 
     * @param id 住院治疗处方主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoePrescriptionById(String id)
    {
        return tMedicalCpoePrescriptionMapper.deleteTMedicalCpoePrescriptionById(id);
    }
}
