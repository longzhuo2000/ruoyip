package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoeSickroomDuty;

/**
 * 病房值班记录Service接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface ITMedicalCpoeSickroomDutyService 
{
    /**
     * 查询病房值班记录
     * 
     * @param id 病房值班记录主键
     * @return 病房值班记录
     */
    public TMedicalCpoeSickroomDuty selectTMedicalCpoeSickroomDutyById(String id);

    /**
     * 查询病房值班记录列表
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 病房值班记录集合
     */
    public List<TMedicalCpoeSickroomDuty> selectTMedicalCpoeSickroomDutyList(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty);

    /**
     * 新增病房值班记录
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 结果
     */
    public int insertTMedicalCpoeSickroomDuty(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty);

    /**
     * 修改病房值班记录
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 结果
     */
    public int updateTMedicalCpoeSickroomDuty(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty);

    /**
     * 批量删除病房值班记录
     * 
     * @param ids 需要删除的病房值班记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoeSickroomDutyByIds(String[] ids);

    /**
     * 删除病房值班记录信息
     * 
     * @param id 病房值班记录主键
     * @return 结果
     */
    public int deleteTMedicalCpoeSickroomDutyById(String id);
}
