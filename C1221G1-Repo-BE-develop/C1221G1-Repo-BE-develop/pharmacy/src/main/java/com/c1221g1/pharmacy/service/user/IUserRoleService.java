package com.c1221g1.pharmacy.service.user;

import com.c1221g1.pharmacy.entity.user.UserRole;

public interface IUserRoleService {
    UserRole findUserRole(String roleName);

    void saveUserRole(UserRole userRole);

}
