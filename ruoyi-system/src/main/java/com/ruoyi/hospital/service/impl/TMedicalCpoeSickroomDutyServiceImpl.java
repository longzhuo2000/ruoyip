package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoeSickroomDutyMapper;
import com.ruoyi.hospital.domain.TMedicalCpoeSickroomDuty;
import com.ruoyi.hospital.service.ITMedicalCpoeSickroomDutyService;

/**
 * 病房值班记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoeSickroomDutyServiceImpl implements ITMedicalCpoeSickroomDutyService 
{
    @Autowired
    private TMedicalCpoeSickroomDutyMapper tMedicalCpoeSickroomDutyMapper;

    /**
     * 查询病房值班记录
     * 
     * @param id 病房值班记录主键
     * @return 病房值班记录
     */
    @Override
    public TMedicalCpoeSickroomDuty selectTMedicalCpoeSickroomDutyById(String id)
    {
        return tMedicalCpoeSickroomDutyMapper.selectTMedicalCpoeSickroomDutyById(id);
    }

    /**
     * 查询病房值班记录列表
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 病房值班记录
     */
    @Override
    public List<TMedicalCpoeSickroomDuty> selectTMedicalCpoeSickroomDutyList(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        return tMedicalCpoeSickroomDutyMapper.selectTMedicalCpoeSickroomDutyList(tMedicalCpoeSickroomDuty);
    }

    /**
     * 新增病房值班记录
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoeSickroomDuty(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        return tMedicalCpoeSickroomDutyMapper.insertTMedicalCpoeSickroomDuty(tMedicalCpoeSickroomDuty);
    }

    /**
     * 修改病房值班记录
     * 
     * @param tMedicalCpoeSickroomDuty 病房值班记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoeSickroomDuty(TMedicalCpoeSickroomDuty tMedicalCpoeSickroomDuty)
    {
        return tMedicalCpoeSickroomDutyMapper.updateTMedicalCpoeSickroomDuty(tMedicalCpoeSickroomDuty);
    }

    /**
     * 批量删除病房值班记录
     * 
     * @param ids 需要删除的病房值班记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSickroomDutyByIds(String[] ids)
    {
        return tMedicalCpoeSickroomDutyMapper.deleteTMedicalCpoeSickroomDutyByIds(ids);
    }

    /**
     * 删除病房值班记录信息
     * 
     * @param id 病房值班记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSickroomDutyById(String id)
    {
        return tMedicalCpoeSickroomDutyMapper.deleteTMedicalCpoeSickroomDutyById(id);
    }
}
