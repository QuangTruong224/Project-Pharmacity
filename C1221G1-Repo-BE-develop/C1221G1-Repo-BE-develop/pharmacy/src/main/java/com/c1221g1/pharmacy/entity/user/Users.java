package com.c1221g1.pharmacy.entity.user;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.c1221g1.pharmacy.entity.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"userRoleList", "customer", "employee"})
public class Users {
    @Id
    @Column(columnDefinition = "VARCHAR(30)")
    private String username;
    private String password;
    private String activeToken;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: this provider use for some one login by social net work
     */
    @Enumerated(EnumType.STRING)
    private Provider provider;
    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UserRole> userRoleList;
    @OneToOne(mappedBy = "customerUsername")
    private Customer customer;
    @OneToOne(mappedBy = "employeeUsername")
    private Employee employee;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
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

    public String getActiveToken() {
        return activeToken;
    }

    public void setActiveToken(String activeToken) {
        this.activeToken = activeToken;
    }
}
