package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoeDoctorsorderhandle;

/**
 * 医嘱执行记录Service接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface ITMedicalCpoeDoctorsorderhandleService 
{
    /**
     * 查询医嘱执行记录
     * 
     * @param id 医嘱执行记录主键
     * @return 医嘱执行记录
     */
    public TMedicalCpoeDoctorsorderhandle selectTMedicalCpoeDoctorsorderhandleById(String id);

    /**
     * 查询医嘱执行记录列表
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 医嘱执行记录集合
     */
    public List<TMedicalCpoeDoctorsorderhandle> selectTMedicalCpoeDoctorsorderhandleList(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle);

    /**
     * 新增医嘱执行记录
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 结果
     */
    public int insertTMedicalCpoeDoctorsorderhandle(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle);

    /**
     * 修改医嘱执行记录
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 结果
     */
    public int updateTMedicalCpoeDoctorsorderhandle(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle);

    /**
     * 批量删除医嘱执行记录
     * 
     * @param ids 需要删除的医嘱执行记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoeDoctorsorderhandleByIds(String[] ids);

    /**
     * 删除医嘱执行记录信息
     * 
     * @param id 医嘱执行记录主键
     * @return 结果
     */
    public int deleteTMedicalCpoeDoctorsorderhandleById(String id);
}
