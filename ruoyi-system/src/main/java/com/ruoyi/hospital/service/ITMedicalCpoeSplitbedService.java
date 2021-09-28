package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.TMedicalCpoeSplitbed;

/**
 * 分床记录Service接口
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public interface ITMedicalCpoeSplitbedService 
{
    /**
     * 查询分床记录
     * 
     * @param id 分床记录主键
     * @return 分床记录
     */
    public TMedicalCpoeSplitbed selectTMedicalCpoeSplitbedById(String id);

    /**
     * 查询分床记录列表
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 分床记录集合
     */
    public List<TMedicalCpoeSplitbed> selectTMedicalCpoeSplitbedList(TMedicalCpoeSplitbed tMedicalCpoeSplitbed);

    /**
     * 新增分床记录
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 结果
     */
    public int insertTMedicalCpoeSplitbed(TMedicalCpoeSplitbed tMedicalCpoeSplitbed);

    /**
     * 修改分床记录
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 结果
     */
    public int updateTMedicalCpoeSplitbed(TMedicalCpoeSplitbed tMedicalCpoeSplitbed);

    /**
     * 批量删除分床记录
     * 
     * @param ids 需要删除的分床记录主键集合
     * @return 结果
     */
    public int deleteTMedicalCpoeSplitbedByIds(String[] ids);

    /**
     * 删除分床记录信息
     * 
     * @param id 分床记录主键
     * @return 结果
     */
    public int deleteTMedicalCpoeSplitbedById(String id);
}
