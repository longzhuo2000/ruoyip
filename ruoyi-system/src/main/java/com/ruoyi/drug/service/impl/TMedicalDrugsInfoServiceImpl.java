package com.ruoyi.drug.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.drug.mapper.TMedicalDrugsInfoMapper;
import com.ruoyi.drug.domain.TMedicalDrugsInfo;
import com.ruoyi.drug.service.ITMedicalDrugsInfoService;

/**
 * 药品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Service
public class TMedicalDrugsInfoServiceImpl implements ITMedicalDrugsInfoService 
{
    @Autowired
    private TMedicalDrugsInfoMapper tMedicalDrugsInfoMapper;

    /**
     * 查询药品
     * 
     * @param id 药品主键
     * @return 药品
     */
    @Override
    public TMedicalDrugsInfo selectTMedicalDrugsInfoById(String id)
    {
        return tMedicalDrugsInfoMapper.selectTMedicalDrugsInfoById(id);
    }

    /**
     * 查询药品列表
     * 
     * @param tMedicalDrugsInfo 药品
     * @return 药品
     */
    @Override
    public List<TMedicalDrugsInfo> selectTMedicalDrugsInfoList(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return tMedicalDrugsInfoMapper.selectTMedicalDrugsInfoList(tMedicalDrugsInfo);
    }

    /**
     * 新增药品
     * 
     * @param tMedicalDrugsInfo 药品
     * @return 结果
     */
    @Override
    public int insertTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return tMedicalDrugsInfoMapper.insertTMedicalDrugsInfo(tMedicalDrugsInfo);
    }

    /**
     * 修改药品
     * 
     * @param tMedicalDrugsInfo 药品
     * @return 结果
     */
    @Override
    public int updateTMedicalDrugsInfo(TMedicalDrugsInfo tMedicalDrugsInfo)
    {
        return tMedicalDrugsInfoMapper.updateTMedicalDrugsInfo(tMedicalDrugsInfo);
    }

    /**
     * 批量删除药品
     * 
     * @param ids 需要删除的药品主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInfoByIds(String[] ids)
    {
        return tMedicalDrugsInfoMapper.deleteTMedicalDrugsInfoByIds(ids);
    }

    /**
     * 删除药品信息
     * 
     * @param id 药品主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalDrugsInfoById(String id)
    {
        return tMedicalDrugsInfoMapper.deleteTMedicalDrugsInfoById(id);
    }
}
