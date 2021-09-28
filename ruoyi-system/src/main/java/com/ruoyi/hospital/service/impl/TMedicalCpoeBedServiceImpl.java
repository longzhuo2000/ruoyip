package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoeBedMapper;
import com.ruoyi.hospital.domain.TMedicalCpoeBed;
import com.ruoyi.hospital.service.ITMedicalCpoeBedService;

/**
 * 床位记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoeBedServiceImpl implements ITMedicalCpoeBedService 
{
    @Autowired
    private TMedicalCpoeBedMapper tMedicalCpoeBedMapper;

    /**
     * 查询床位记录
     * 
     * @param id 床位记录主键
     * @return 床位记录
     */
    @Override
    public TMedicalCpoeBed selectTMedicalCpoeBedById(String id)
    {
        return tMedicalCpoeBedMapper.selectTMedicalCpoeBedById(id);
    }

    /**
     * 查询床位记录列表
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 床位记录
     */
    @Override
    public List<TMedicalCpoeBed> selectTMedicalCpoeBedList(TMedicalCpoeBed tMedicalCpoeBed)
    {
        return tMedicalCpoeBedMapper.selectTMedicalCpoeBedList(tMedicalCpoeBed);
    }

    /**
     * 新增床位记录
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoeBed(TMedicalCpoeBed tMedicalCpoeBed)
    {
        return tMedicalCpoeBedMapper.insertTMedicalCpoeBed(tMedicalCpoeBed);
    }

    /**
     * 修改床位记录
     * 
     * @param tMedicalCpoeBed 床位记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoeBed(TMedicalCpoeBed tMedicalCpoeBed)
    {
        return tMedicalCpoeBedMapper.updateTMedicalCpoeBed(tMedicalCpoeBed);
    }

    /**
     * 批量删除床位记录
     * 
     * @param ids 需要删除的床位记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeBedByIds(String[] ids)
    {
        return tMedicalCpoeBedMapper.deleteTMedicalCpoeBedByIds(ids);
    }

    /**
     * 删除床位记录信息
     * 
     * @param id 床位记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeBedById(String id)
    {
        return tMedicalCpoeBedMapper.deleteTMedicalCpoeBedById(id);
    }
}
