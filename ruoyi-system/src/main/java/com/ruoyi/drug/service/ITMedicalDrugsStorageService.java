package com.ruoyi.drug.service;

import java.util.List;
import com.ruoyi.drug.domain.TMedicalDrugsStorage;

/**
 * 药库库存Service接口
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public interface ITMedicalDrugsStorageService 
{
    /**
     * 查询药库库存
     * 
     * @param id 药库库存主键
     * @return 药库库存
     */
    public TMedicalDrugsStorage selectTMedicalDrugsStorageById(String id);

    /**
     * 查询药库库存列表
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 药库库存集合
     */
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageList(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 新增药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    public int insertTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 修改药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    public int updateTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage);

    /**
     * 批量删除药库库存
     * 
     * @param ids 需要删除的药库库存主键集合
     * @return 结果
     */
    public int deleteTMedicalDrugsStorageByIds(String[] ids);

    /**
     * 删除药库库存信息
     * 
     * @param id 药库库存主键
     * @return 结果
     */
    public int deleteTMedicalDrugsStorageById(String id);
}
