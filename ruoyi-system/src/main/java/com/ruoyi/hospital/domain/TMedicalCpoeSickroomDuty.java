package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 病房值班记录对象 t_medical_cpoe_sickroom_duty
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoeSickroomDuty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 病房id */
    @Excel(name = "病房id")
    private String sickroomid;

    /** 值班医生 */
    @Excel(name = "值班医生")
    private String doctorid;

    /** 值班护士 */
    @Excel(name = "值班护士")
    private String nurseid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setSickroomid(String sickroomid) 
    {
        this.sickroomid = sickroomid;
    }

    public String getSickroomid() 
    {
        return sickroomid;
    }
    public void setDoctorid(String doctorid) 
    {
        this.doctorid = doctorid;
    }

    public String getDoctorid() 
    {
        return doctorid;
    }
    public void setNurseid(String nurseid) 
    {
        this.nurseid = nurseid;
    }

    public String getNurseid() 
    {
        return nurseid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sickroomid", getSickroomid())
            .append("doctorid", getDoctorid())
            .append("nurseid", getNurseid())
            .toString();
    }
}
