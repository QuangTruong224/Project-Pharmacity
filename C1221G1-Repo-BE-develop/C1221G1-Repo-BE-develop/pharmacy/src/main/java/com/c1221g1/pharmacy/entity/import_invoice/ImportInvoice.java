package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"importInvoiceMedicineList"})
public class ImportInvoice {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HDN"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String importInvoiceId;
    private Integer importSystemCode;
    private Double paymentPrepayment;
    private Double total;
    @Column(columnDefinition = "DATE")
    private String importInvoiceDate;
    private String importInvoiceHour;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;
    @OneToMany(mappedBy = "importInvoice")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;

    public ImportInvoice() {
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

}

