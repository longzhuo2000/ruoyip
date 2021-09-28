package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 床位记录对象 t_medical_cpoe_bed
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoeBed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 床位名称 */
    @Excel(name = "床位名称")
    private String name;

    /** 病房id */
    @Excel(name = "病房id")
    private String sickroomid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSickroomid(String sickroomid) 
    {
        this.sickroomid = sickroomid;
    }

    public String getSickroomid() 
    {
        return sickroomid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sickroomid", getSickroomid())
            .append("remark", getRemark())
            .toString();
    }
}
