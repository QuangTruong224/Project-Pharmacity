package com.c1221g1.pharmacy.dto.trung_dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ImportInvoiceDtoTrung implements Validator {
    private String importInvoiceId;
    @NotNull
    private Integer importSystemCode;
    @NotNull
    private String importInvoiceDate;
    @NotNull
    private boolean flag;
    private List<ImportInvoiceMedicineDtoTrung> importInvoiceMedicineDtoTrungList;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ImportInvoiceDtoTrung importInvoiceDtoTrung = (ImportInvoiceDtoTrung) target;
    }

    public ImportInvoiceDtoTrung() {
    }

    public String getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(String importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public Integer getImportSystemCode() {
        return importSystemCode;
    }

    public void setImportSystemCode(Integer importSystemCode) {
        this.importSystemCode = importSystemCode;
    }

    public String getImportInvoiceDate() {
        return importInvoiceDate;
    }

    public void setImportInvoiceDate(String importInvoiceDate) {
        this.importInvoiceDate = importInvoiceDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<ImportInvoiceMedicineDtoTrung> getImportInvoiceMedicineDtoTrungList() {
        return importInvoiceMedicineDtoTrungList;
    }

    public void setImportInvoiceMedicineDtoTrungList(List<ImportInvoiceMedicineDtoTrung> importInvoiceMedicineDtoTrungList) {
        this.importInvoiceMedicineDtoTrungList = importInvoiceMedicineDtoTrungList;
    }
}
