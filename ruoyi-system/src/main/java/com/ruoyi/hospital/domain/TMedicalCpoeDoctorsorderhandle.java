package com.ruoyi.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医嘱执行记录对象 t_medical_cpoe_doctorsorderhandle
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoeDoctorsorderhandle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 操作人 */
    @Excel(name = "操作人")
    private String userid;

    /** 医嘱记录Id */
    @Excel(name = "医嘱记录Id")
    private String doctorsorderid;

    /** 医嘱执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "医嘱执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moretime;

    /** 1正常2异常 */
    @Excel(name = "1正常2异常")
    private Long result;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
    {
        return userid;
    }
    public void setDoctorsorderid(String doctorsorderid) 
    {
        this.doctorsorderid = doctorsorderid;
    }

    public String getDoctorsorderid() 
    {
        return doctorsorderid;
    }
    public void setMoretime(Date moretime) 
    {
        this.moretime = moretime;
    }

    public Date getMoretime() 
    {
        return moretime;
    }
    public void setResult(Long result) 
    {
        this.result = result;
    }

    public Long getResult() 
    {
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("doctorsorderid", getDoctorsorderid())
            .append("moretime", getMoretime())
            .append("result", getResult())
            .append("remark", getRemark())
            .toString();
    }
}
