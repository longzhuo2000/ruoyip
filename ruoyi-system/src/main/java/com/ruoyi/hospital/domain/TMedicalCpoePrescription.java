package com.ruoyi.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 住院治疗处方对象 t_medical_cpoe_prescription
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoePrescription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 当天处方汇总Id */
    @Excel(name = "当天处方汇总Id")
    private String prescriptiontotalid;

    /** 医嘱记录Id */
    @Excel(name = "医嘱记录Id")
    private String doctorsorderid;

    /** 药品表ID */
    @Excel(name = "药品表ID")
    private String partid;

    /** 用量 */
    @Excel(name = "用量")
    private String partno;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moretime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPrescriptiontotalid(String prescriptiontotalid) 
    {
        this.prescriptiontotalid = prescriptiontotalid;
    }

    public String getPrescriptiontotalid() 
    {
        return prescriptiontotalid;
    }
    public void setDoctorsorderid(String doctorsorderid) 
    {
        this.doctorsorderid = doctorsorderid;
    }

    public String getDoctorsorderid() 
    {
        return doctorsorderid;
    }
    public void setPartid(String partid) 
    {
        this.partid = partid;
    }

    public String getPartid() 
    {
        return partid;
    }
    public void setPartno(String partno) 
    {
        this.partno = partno;
    }

    public String getPartno() 
    {
        return partno;
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
            .append("prescriptiontotalid", getPrescriptiontotalid())
            .append("doctorsorderid", getDoctorsorderid())
            .append("partid", getPartid())
            .append("partno", getPartno())
            .append("moretime", getMoretime())
            .append("remark", getRemark())
            .toString();
    }
}
