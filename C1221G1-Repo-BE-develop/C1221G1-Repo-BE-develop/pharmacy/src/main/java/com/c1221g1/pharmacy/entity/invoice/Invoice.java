package com.c1221g1.pharmacy.entity.invoice;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"invoiceMedicineList"})
public class Invoice {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HD"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String invoiceId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "type_of_invoice_id", referencedColumnName = "typeOfInvoiceId", nullable = false)
    private TypeOfInvoice typeOfInvoice;
    @Column(columnDefinition = "LONGTEXT")
    private String invoiceNote;
    private String invoiceCreatedDate;

    /*
     * Created by DaLQA
     * Time: 8:36 PM 30/06/2022
     * Function: create new property invoiceCreateTime
     * */
//    private Double invoiceTotalMoney;
    /*
     * Created by DaLQA
     * Time: 4:12 PM 29/06/2022
     * Function: create new property invoiceCreateTime
     * */
    private String invoiceCreateTime;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @JsonBackReference(value = "invoiceMedicineList")
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceMedicine> invoiceMedicineList;

    public Invoice() {
    }

    public String getInvoiceCreateTime() {
        return invoiceCreateTime;
    }

    public void setInvoiceCreateTime(String invoiceCreateTime) {
        this.invoiceCreateTime = invoiceCreateTime;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TypeOfInvoice getTypeOfInvoice() {
        return typeOfInvoice;
    }

    public void setTypeOfInvoice(TypeOfInvoice typeOfInvoice) {
        this.typeOfInvoice = typeOfInvoice;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceCreatedDate() {
        return invoiceCreatedDate;
    }

    public void setInvoiceCreatedDate(String invoiceCreatedDate) {
        this.invoiceCreatedDate = invoiceCreatedDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<InvoiceMedicine> getInvoiceMedicineList() {
        return invoiceMedicineList;
    }

    public void setInvoiceMedicineList(List<InvoiceMedicine> invoiceMedicineList) {
        this.invoiceMedicineList = invoiceMedicineList;
    }
}
