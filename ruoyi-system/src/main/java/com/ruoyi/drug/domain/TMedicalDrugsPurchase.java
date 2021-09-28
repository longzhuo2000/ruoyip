package com.ruoyi.drug.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品采购信息对象 t_medical_drugs_purchase
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public class TMedicalDrugsPurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随机 */
    private String id;

    /** 药品名称ID */
    @Excel(name = "药品名称ID")
    private String drugsid;

    /** 药品来源 */
    @Excel(name = "药品来源")
    private String source;

    /** 产地 */
    @Excel(name = "产地")
    private String address;

    /** 批号 */
    @Excel(name = "批号")
    private String batchnumbe;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufacturetime;

    /** 有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date termofvalidity;

    /** 摘要 */
    @Excel(name = "摘要")
    private String abstracts;

    /** 填制人 */
    @Excel(name = "填制人")
    private String filledby;

    /** 核查人 */
    @Excel(name = "核查人")
    private String verifier;

    /** 核查日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核查日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date verificationtime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewer;

    /** 审核日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date audittime;

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
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setBatchnumbe(String batchnumbe) 
    {
        this.batchnumbe = batchnumbe;
    }

    public String getBatchnumbe() 
    {
        return batchnumbe;
    }
    public void setManufacturetime(Date manufacturetime) 
    {
        this.manufacturetime = manufacturetime;
    }

    public Date getManufacturetime() 
    {
        return manufacturetime;
    }
    public void setTermofvalidity(Date termofvalidity) 
    {
        this.termofvalidity = termofvalidity;
    }

    public Date getTermofvalidity() 
    {
        return termofvalidity;
    }
    public void setAbstracts(String abstracts) 
    {
        this.abstracts = abstracts;
    }

    public String getAbstracts() 
    {
        return abstracts;
    }
    public void setFilledby(String filledby) 
    {
        this.filledby = filledby;
    }

    public String getFilledby() 
    {
        return filledby;
    }
    public void setVerifier(String verifier) 
    {
        this.verifier = verifier;
    }

    public String getVerifier() 
    {
        return verifier;
    }
    public void setVerificationtime(Date verificationtime) 
    {
        this.verificationtime = verificationtime;
    }

    public Date getVerificationtime() 
    {
        return verificationtime;
    }
    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }

    public String getReviewer() 
    {
        return reviewer;
    }
    public void setAudittime(Date audittime) 
    {
        this.audittime = audittime;
    }

    public Date getAudittime() 
    {
        return audittime;
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
            .append("source", getSource())
            .append("address", getAddress())
            .append("batchnumbe", getBatchnumbe())
            .append("manufacturetime", getManufacturetime())
            .append("termofvalidity", getTermofvalidity())
            .append("abstracts", getAbstracts())
            .append("filledby", getFilledby())
            .append("verifier", getVerifier())
            .append("verificationtime", getVerificationtime())
            .append("reviewer", getReviewer())
            .append("audittime", getAudittime())
            .append("no", getNo())
            .toString();
    }
}
