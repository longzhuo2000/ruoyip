package com.ruoyi.hospital.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.TMedicalCpoeDoctorsorderhandleMapper;
import com.ruoyi.hospital.domain.TMedicalCpoeDoctorsorderhandle;
import com.ruoyi.hospital.service.ITMedicalCpoeDoctorsorderhandleService;

/**
 * 医嘱执行记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
@Service
public class TMedicalCpoeDoctorsorderhandleServiceImpl implements ITMedicalCpoeDoctorsorderhandleService 
{
    @Autowired
    private TMedicalCpoeDoctorsorderhandleMapper tMedicalCpoeDoctorsorderhandleMapper;

    /**
     * 查询医嘱执行记录
     * 
     * @param id 医嘱执行记录主键
     * @return 医嘱执行记录
     */
    @Override
    public TMedicalCpoeDoctorsorderhandle selectTMedicalCpoeDoctorsorderhandleById(String id)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.selectTMedicalCpoeDoctorsorderhandleById(id);
    }

    /**
     * 查询医嘱执行记录列表
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 医嘱执行记录
     */
    @Override
    public List<TMedicalCpoeDoctorsorderhandle> selectTMedicalCpoeDoctorsorderhandleList(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.selectTMedicalCpoeDoctorsorderhandleList(tMedicalCpoeDoctorsorderhandle);
    }

    /**
     * 新增医嘱执行记录
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 结果
     */
    @Override
    public int insertTMedicalCpoeDoctorsorderhandle(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.insertTMedicalCpoeDoctorsorderhandle(tMedicalCpoeDoctorsorderhandle);
    }

    /**
     * 修改医嘱执行记录
     * 
     * @param tMedicalCpoeDoctorsorderhandle 医嘱执行记录
     * @return 结果
     */
    @Override
    public int updateTMedicalCpoeDoctorsorderhandle(TMedicalCpoeDoctorsorderhandle tMedicalCpoeDoctorsorderhandle)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.updateTMedicalCpoeDoctorsorderhandle(tMedicalCpoeDoctorsorderhandle);
    }

    /**
     * 批量删除医嘱执行记录
     * 
     * @param ids 需要删除的医嘱执行记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeDoctorsorderhandleByIds(String[] ids)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.deleteTMedicalCpoeDoctorsorderhandleByIds(ids);
    }

    /**
     * 删除医嘱执行记录信息
     * 
     * @param id 医嘱执行记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCpoeDoctorsorderhandleById(String id)
    {
        return tMedicalCpoeDoctorsorderhandleMapper.deleteTMedicalCpoeDoctorsorderhandleById(id);
    }
}
