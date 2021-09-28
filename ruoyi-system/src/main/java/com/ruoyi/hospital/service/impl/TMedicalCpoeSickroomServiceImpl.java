package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoeSickroomMapper;
import com.ruoyi.hospital.domain.TMedicalCpoeSickroom;
import com.ruoyi.hospital.service.ITMedicalCpoeSickroomService;

/**
 * 病房记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoeSickroomServiceImpl implements ITMedicalCpoeSickroomService 
{
    @Autowired
    private TMedicalCpoeSickroomMapper tMedicalCpoeSickroomMapper;

    /**
     * 查询病房记录
     * 
     * @param id 病房记录主键
     * @return 病房记录
     */
    @Override
    public TMedicalCpoeSickroom selectTMedicalCpoeSickroomById(String id)
    {
        return tMedicalCpoeSickroomMapper.selectTMedicalCpoeSickroomById(id);
    }

    /**
     * 查询病房记录列表
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 病房记录
     */
    @Override
    public List<TMedicalCpoeSickroom> selectTMedicalCpoeSickroomList(TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        return tMedicalCpoeSickroomMapper.selectTMedicalCpoeSickroomList(tMedicalCpoeSickroom);
    }

    /**
     * 新增病房记录
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoeSickroom(TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        return tMedicalCpoeSickroomMapper.insertTMedicalCpoeSickroom(tMedicalCpoeSickroom);
    }

    /**
     * 修改病房记录
     * 
     * @param tMedicalCpoeSickroom 病房记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoeSickroom(TMedicalCpoeSickroom tMedicalCpoeSickroom)
    {
        return tMedicalCpoeSickroomMapper.updateTMedicalCpoeSickroom(tMedicalCpoeSickroom);
    }

    /**
     * 批量删除病房记录
     * 
     * @param ids 需要删除的病房记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSickroomByIds(String[] ids)
    {
        return tMedicalCpoeSickroomMapper.deleteTMedicalCpoeSickroomByIds(ids);
    }

    /**
     * 删除病房记录信息
     * 
     * @param id 病房记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeSickroomById(String id)
    {
        return tMedicalCpoeSickroomMapper.deleteTMedicalCpoeSickroomById(id);
    }
}
