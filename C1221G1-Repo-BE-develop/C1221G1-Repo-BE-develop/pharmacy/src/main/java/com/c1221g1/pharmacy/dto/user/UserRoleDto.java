package com.c1221g1.pharmacy.dto.user;

import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.Users;

public class UserRoleDto {
    private Integer userRoleId;
    private Users users;
    private Roles roles;

    public UserRoleDto() {
        // nothing
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
