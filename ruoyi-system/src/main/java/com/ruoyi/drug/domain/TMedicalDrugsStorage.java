package com.ruoyi.drug.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药库库存对象 t_medical_drugs_storage
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public class TMedicalDrugsStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 数量 */
    @Excel(name = "数量")
    private Integer no;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugsid(String drugsid) 
    {
        this.drugsid = drugsid;
    }

    public String getDrugsid() 
    {
        return drugsid;
    }
    public void setNo(Integer no) 
    {
        this.no = no;
    }

    public Integer getNo() 
    {
        return no;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugsid", getDrugsid())
            .append("no", getNo())
            .toString();
    }
}
