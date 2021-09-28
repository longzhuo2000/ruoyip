package com.ruoyi.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 住院治疗处方总对象 t_medical_cpoe_prescriptiontotal
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoePrescriptiontotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 1草稿2发送3撤回4退回5完成认领 */
    @Excel(name = "1草稿2发送3撤回4退回5完成认领")
    private Long statue;

    /** 药品表ID */
    @Excel(name = "药品表ID")
    private String partid;

    /** 单位支/盒/克 */
    @Excel(name = "单位支/盒/克")
    private String parttype;

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
    public void setStatue(Long statue) 
    {
        this.statue = statue;
    }

    public Long getStatue() 
    {
        return statue;
    }
    public void setPartid(String partid) 
    {
        this.partid = partid;
    }

    public String getPartid() 
    {
        return partid;
    }
    public void setParttype(String parttype) 
    {
        this.parttype = parttype;
    }

    public String getParttype() 
    {
        return parttype;
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
            .append("statue", getStatue())
            .append("partid", getPartid())
            .append("parttype", getParttype())
            .append("partno", getPartno())
            .append("moretime", getMoretime())
            .append("remark", getRemark())
            .toString();
    }
}
