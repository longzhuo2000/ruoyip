package com.ruoyi.drug.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.drug.mapper.TMedicalDrugsStorageMapper;
import com.ruoyi.drug.domain.TMedicalDrugsStorage;
import com.ruoyi.drug.service.ITMedicalDrugsStorageService;

/**
 * 药库库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Service
public class TMedicalDrugsStorageServiceImpl implements ITMedicalDrugsStorageService 
{
    @Autowired
    private TMedicalDrugsStorageMapper tMedicalDrugsStorageMapper;

    /**
     * 查询药库库存
     * 
     * @param id 药库库存主键
     * @return 药库库存
     */
    @Override
    public TMedicalDrugsStorage selectTMedicalDrugsStorageById(String id)
    {
        return tMedicalDrugsStorageMapper.selectTMedicalDrugsStorageById(id);
    }

    /**
     * 查询药库库存列表
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 药库库存
     */
    @Override
    public List<TMedicalDrugsStorage> selectTMedicalDrugsStorageList(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        return tMedicalDrugsStorageMapper.selectTMedicalDrugsStorageList(tMedicalDrugsStorage);
    }

    /**
     * 新增药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        return tMedicalDrugsStorageMapper.insertTMedicalDrugsStorage(tMedicalDrugsStorage);
    }

    /**
     * 修改药库库存
     * 
     * @param tMedicalDrugsStorage 药库库存
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage)
    {
        return tMedicalDrugsStorageMapper.updateTMedicalDrugsStorage(tMedicalDrugsStorage);
    }

    /**
     * 批量删除药库库存
     * 
     * @param ids 需要删除的药库库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsStorageByIds(String[] ids)
    {
        return tMedicalDrugsStorageMapper.deleteTMedicalDrugsStorageByIds(ids);
    }

    /**
     * 删除药库库存信息
     * 
     * @param id 药库库存主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsStorageById(String id)
    {
        return tMedicalDrugsStorageMapper.deleteTMedicalDrugsStorageById(id);
    }
}
