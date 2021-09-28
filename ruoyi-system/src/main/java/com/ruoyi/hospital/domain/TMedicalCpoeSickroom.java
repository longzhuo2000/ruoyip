package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 病房记录对象 t_medical_cpoe_sickroom
 * 
 * @author ruoyi
 * @date 2021-09-24
 */
public class TMedicalCpoeSickroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 病房名称 */
    @Excel(name = "病房名称")
    private String name;

    /** N人房 */
    @Excel(name = "N人房")
    private String unit;

    /** 属性，儿童科、耳鼻科 */
    @Excel(name = "属性，儿童科、耳鼻科")
    private String attribute;

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
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setAttribute(String attribute) 
    {
        this.attribute = attribute;
    }

    public String getAttribute() 
    {
        return attribute;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("unit", getUnit())
            .append("attribute", getAttribute())
            .append("remark", getRemark())
            .toString();
    }
}
