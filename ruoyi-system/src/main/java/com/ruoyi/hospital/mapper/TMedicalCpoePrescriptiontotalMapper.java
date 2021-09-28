package com.ruoyi.hospital.mapper;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoePrescriptiontotal;

/**
 * 住院治疗处方总Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface TMedicalCpoePrescriptiontotalMapper 
{
    /**
     * 查询住院治疗处方总
     * 
     * @param id 住院治疗处方总主键
     * @return 住院治疗处方总
     */
    public TMedicalCpoePrescriptiontotal selectTMedicalCpoePrescriptiontotalById(String id);

    /**
     * 查询住院治疗处方总列表
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 住院治疗处方总集合
     */
    public List<TMedicalCpoePrescriptiontotal> selectTMedicalCpoePrescriptiontotalList(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal);

    /**
     * 新增住院治疗处方总
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 结果
     */
    public int insertTMedicalCpoePrescriptiontotal(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal);

    /**
     * 修改住院治疗处方总
     * 
     * @param tMedicalCpoePrescriptiontotal 住院治疗处方总
     * @return 结果
     */
    public int updateTMedicalCpoePrescriptiontotal(TMedicalCpoePrescriptiontotal tMedicalCpoePrescriptiontotal);

    /**
     * 删除住院治疗处方总
     * 
     * @param id 住院治疗处方总主键
     * @return 结果
     */
    public int deleteTMedicalCpoePrescriptiontotalById(String id);

    /**
     * 批量删除住院治疗处方总
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoePrescriptiontotalByIds(String[] ids);
}
