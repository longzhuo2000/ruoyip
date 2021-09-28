package com.ruoyi.drug.domain.dto;

import com.ruoyi.drug.domain.TMedicalDrugsInventoryRecord;
import com.ruoyi.drug.domain.TMedicalDrugsPurchase;

public class PharmacyiInventoryDto {
    private TMedicalDrugsPurchase purchase;
    private TMedicalDrugsInventoryRecord record;

    public TMedicalDrugsPurchase getPurchase() {
        return purchase;
    }

    public void setPurchase(TMedicalDrugsPurchase purchase) {
        this.purchase = purchase;
    }

    public TMedicalDrugsInventoryRecord getRecord() {
        return record;
    }

    public void setRecord(TMedicalDrugsInventoryRecord record) {
        this.record = record;
    }
}
