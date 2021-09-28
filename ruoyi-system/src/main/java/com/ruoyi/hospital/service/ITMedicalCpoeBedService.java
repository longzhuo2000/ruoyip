package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoeBed;

/**
 * 床位记录Service接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface ITMedicalCpoeBedService 
{
    /**
     * 查询床位记录
     * 
     * @param id 床位记录主键
     * @return 床位记录
     */
    public TMedicalCpoeBed selectTMedicalCpoeBedById(String id);

    /**
     * 查询床位记录列表
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 床位记录集合
     */
    public List<TMedicalCpoeBed> selectTMedicalCpoeBedList(TMedicalCpoeBed tMedicalCpoeBed);

    /**
     * 新增床位记录
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 结果
     */
    public int insertTMedicalCpoeBed(TMedicalCpoeBed tMedicalCpoeBed);

    /**
     * 修改床位记录
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 结果
     */
    public int updateTMedicalCpoeBed(TMedicalCpoeBed tMedicalCpoeBed);

    /**
     * 批量删除床位记录
     * 
     * @param ids 需要删除的床位记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoeBedByIds(String[] ids);

    /**
     * 删除床位记录信息
     * 
     * @param id 床位记录主键
     * @return 结果
     */
    public int deleteTMedicalCpoeBedById(String id);
}
