package com.ruoyi.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分床记录对象 t_medical_cpoe_splitbed
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoeSplitbed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 患者id */
    @Excel(name = "患者id")
    private String personid;

    /** 主职医生ID */
    @Excel(name = "主职医生ID")
    private String doctorid;

    /** 床位ID */
    @Excel(name = "床位ID")
    private String bedid;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moretime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPersonid(String personid) 
    {
        this.personid = personid;
    }

    public String getPersonid() 
    {
        return personid;
    }
    public void setDoctorid(String doctorid) 
    {
        this.doctorid = doctorid;
    }

    public String getDoctorid() 
    {
        return doctorid;
    }
    public void setBedid(String bedid) 
    {
        this.bedid = bedid;
    }

    public String getBedid() 
    {
        return bedid;
    }
    public void setMoretime(Date moretime) 
    {
        this.moretime = moretime;
    }

    public Date getMoretime() 
    {
        return moretime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personid", getPersonid())
            .append("doctorid", getDoctorid())
            .append("bedid", getBedid())
            .append("moretime", getMoretime())
            .append("remark", getRemark())
            .toString();
    }
}
