package com.ruoyi.drug.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品对象 t_medical_drugs_info
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public class TMedicalDrugsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 药品描述 */
    @Excel(name = "药品描述")
    private String description;

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
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("specifications", getSpecifications())
            .append("unit", getUnit())
            .append("description", getDescription())
            .toString();
    }
}
