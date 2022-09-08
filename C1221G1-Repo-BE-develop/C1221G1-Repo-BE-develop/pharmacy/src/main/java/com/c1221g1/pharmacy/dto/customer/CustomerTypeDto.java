package com.c1221g1.pharmacy.dto.customer;
import com.c1221g1.pharmacy.entity.customer.Customer;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CustomerTypeDto {
    @NotNull(message = "Name may not be null")
    private Integer customerTypeId;
    private String customerTypeName;
    private List<Customer> customerList;

    public CustomerTypeDto() {
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
