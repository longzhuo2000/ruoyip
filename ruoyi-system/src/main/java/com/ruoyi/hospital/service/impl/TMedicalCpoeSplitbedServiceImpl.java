package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoeSplitbedMapper;
import com.ruoyi.hospital.domain.TMedicalCpoeSplitbed;
import com.ruoyi.hospital.service.ITMedicalCpoeSplitbedService;

/**
 * 分床记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoeSplitbedServiceImpl implements ITMedicalCpoeSplitbedService 
{
    @Autowired
    private TMedicalCpoeSplitbedMapper tMedicalCpoeSplitbedMapper;

    /**
     * 查询分床记录
     * 
     * @param id 分床记录主键
     * @return 分床记录
     */
    @Override
    public TMedicalCpoeSplitbed selectTMedicalCpoeSplitbedById(String id)
    {
        return tMedicalCpoeSplitbedMapper.selectTMedicalCpoeSplitbedById(id);
    }

    /**
     * 查询分床记录列表
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 分床记录
     */
    @Override
    public List<TMedicalCpoeSplitbed> selectTMedicalCpoeSplitbedList(TMedicalCpoeSplitbed tMedicalCpoeSplitbed)
    {
        return tMedicalCpoeSplitbedMapper.selectTMedicalCpoeSplitbedList(tMedicalCpoeSplitbed);
    }

    /**
     * 新增分床记录
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoeSplitbed(TMedicalCpoeSplitbed tMedicalCpoeSplitbed)
    {
        return tMedicalCpoeSplitbedMapper.insertTMedicalCpoeSplitbed(tMedicalCpoeSplitbed);
    }

    /**
     * 修改分床记录
     * 
     * @param tMedicalCpoeSplitbed 分床记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoeSplitbed(TMedicalCpoeSplitbed tMedicalCpoeSplitbed)
    {
        return tMedicalCpoeSplitbedMapper.updateTMedicalCpoeSplitbed(tMedicalCpoeSplitbed);
    }

    /**
     * 批量删除分床记录
     * 
     * @param ids 需要删除的分床记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSplitbedByIds(String[] ids)
    {
        return tMedicalCpoeSplitbedMapper.deleteTMedicalCpoeSplitbedByIds(ids);
    }

    /**
     * 删除分床记录信息
     * 
     * @param id 分床记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSplitbedById(String id)
    {
        return tMedicalCpoeSplitbedMapper.deleteTMedicalCpoeSplitbedById(id);
    }
}
