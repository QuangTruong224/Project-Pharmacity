package com.c1221g1.pharmacy.dto.account;

import com.c1221g1.pharmacy.entity.employee.Position;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountEmployeeDto {
    String employeeId;
    String employeeName;
    @NotNull
    Position position;

    String username;

    @NotNull
    @Size(min = 6)
    String password;

    public AccountEmployeeDto() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

//    public Integer getPositionId() {
//        return positionId;
//    }
//
//    public void setPositionId(Integer positionId) {
//        this.positionId = positionId;
//    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
}
