package com.c1221g1.pharmacy.dto.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ImportInvoiceDto implements Validator {
    private String importInvoiceId;
    private Integer importSystemCode;
    @NotNull
    private Double paymentPrepayment;
    private Double total;
    private String importInvoiceDate;
    private String importInvoiceHour;
    private boolean flag;
    private Supplier supplier;
    private Employee employee;
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;

    public ImportInvoiceDto() {
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

    public Double getPaymentPrepayment() {
        return paymentPrepayment;
    }

    public void setPaymentPrepayment(Double paymentPrepayment) {
        this.paymentPrepayment = paymentPrepayment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getImportInvoiceDate() {
        return importInvoiceDate;
    }

    public void setImportInvoiceDate(String importInvoiceDate) {
        this.importInvoiceDate = importInvoiceDate;
    }

    public String getImportInvoiceHour() {
        return importInvoiceHour;
    }

    public void setImportInvoiceHour(String importInvoiceHour) {
        this.importInvoiceHour = importInvoiceHour;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ImportInvoiceMedicine> getImportInvoiceMedicineList() {
        return importInvoiceMedicineList;
    }

    public void setImportInvoiceMedicineList(List<ImportInvoiceMedicine> importInvoiceMedicineList) {
        this.importInvoiceMedicineList = importInvoiceMedicineList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ImportInvoiceDto importInvoiceDto = (ImportInvoiceDto) target;
    }
}
