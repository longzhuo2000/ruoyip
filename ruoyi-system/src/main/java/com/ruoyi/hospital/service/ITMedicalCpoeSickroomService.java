package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoeSickroom;

/**
 * 病房记录Service接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface ITMedicalCpoeSickroomService 
{
    /**
     * 查询病房记录
     * 
     * @param id 病房记录主键
     * @return 病房记录
     */
    public TMedicalCpoeSickroom selectTMedicalCpoeSickroomById(String id);

    /**
     * 查询病房记录列表
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 病房记录集合
     */
    public List<TMedicalCpoeSickroom> selectTMedicalCpoeSickroomList(TMedicalCpoeSickroom tMedicalCpoeSickroom);

    /**
     * 新增病房记录
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 结果
     */
    public int insertTMedicalCpoeSickroom(TMedicalCpoeSickroom tMedicalCpoeSickroom);

    /**
     * 修改病房记录
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 结果
     */
    public int updateTMedicalCpoeSickroom(TMedicalCpoeSickroom tMedicalCpoeSickroom);

    /**
     * 批量删除病房记录
     * 
     * @param ids 需要删除的病房记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoeSickroomByIds(String[] ids);

    /**
     * 删除病房记录信息
     * 
     * @param id 病房记录主键
     * @return 结果
     */
    public int deleteTMedicalCpoeSickroomById(String id);
}
