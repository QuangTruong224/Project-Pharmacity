package com.c1221g1.pharmacy.service.user;

import com.c1221g1.pharmacy.entity.user.Roles;

public interface IRoleService {

    Roles findRoleByName(String roleUser);


    void saveRole(Roles roles);
}
