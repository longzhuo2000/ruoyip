package com.ruoyi.drug.domain.dto;

import com.ruoyi.drug.domain.TMedicalDrugsInventoryRecord;
import com.ruoyi.drug.domain.TMedicalDrugsStorage;

public class RecordStorageDto {
    private TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord;
    private TMedicalDrugsStorage tMedicalDrugsStorage;

    public TMedicalDrugsInventoryRecord gettMedicalDrugsInventoryRecord() {
        return tMedicalDrugsInventoryRecord;
    }

    public void settMedicalDrugsInventoryRecord(TMedicalDrugsInventoryRecord tMedicalDrugsInventoryRecord) {
        this.tMedicalDrugsInventoryRecord = tMedicalDrugsInventoryRecord;
    }

    public TMedicalDrugsStorage gettMedicalDrugsStorage() {
        return tMedicalDrugsStorage;
    }

    public void settMedicalDrugsStorage(TMedicalDrugsStorage tMedicalDrugsStorage) {
        this.tMedicalDrugsStorage = tMedicalDrugsStorage;
    }
}
