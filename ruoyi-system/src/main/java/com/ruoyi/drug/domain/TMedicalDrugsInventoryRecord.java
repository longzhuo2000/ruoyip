package com.ruoyi.drug.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点记录对象 t_medical_drugs_inventory_record
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public class TMedicalDrugsInventoryRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 账面数量 */
    @Excel(name = "账面数量")
    private Integer papernumber;

    /** 实存数量 */
    @Excel(name = "实存数量")
    private String existnumber;

    /** 购进单价 */
    @Excel(name = "购进单价")
    private Long buyunitprice;

    /** 零售单价 */
    @Excel(name = "零售单价")
    private Long sellunitprice;

    /** 盘盈数量 */
    @Excel(name = "盘盈数量")
    private Integer inventorysurplusno;

    /** 盘点时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "盘点时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date moretime;

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
    public void setPapernumber(Integer papernumber) 
    {
        this.papernumber = papernumber;
    }

    public Integer getPapernumber() 
    {
        return papernumber;
    }
    public void setExistnumber(String existnumber) 
    {
        this.existnumber = existnumber;
    }

    public String getExistnumber() 
    {
        return existnumber;
    }
    public void setBuyunitprice(Long buyunitprice) 
    {
        this.buyunitprice = buyunitprice;
    }

    public Long getBuyunitprice() 
    {
        return buyunitprice;
    }
    public void setSellunitprice(Long sellunitprice) 
    {
        this.sellunitprice = sellunitprice;
    }

    public Long getSellunitprice() 
    {
        return sellunitprice;
    }
    public void setInventorysurplusno(Integer inventorysurplusno) 
    {
        this.inventorysurplusno = inventorysurplusno;
    }

    public Integer getInventorysurplusno() 
    {
        return inventorysurplusno;
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
            .append("drugsid", getDrugsid())
            .append("papernumber", getPapernumber())
            .append("existnumber", getExistnumber())
            .append("buyunitprice", getBuyunitprice())
            .append("sellunitprice", getSellunitprice())
            .append("inventorysurplusno", getInventorysurplusno())
            .append("moretime", getMoretime())
            .append("remark", getRemark())
            .toString();
    }
}
