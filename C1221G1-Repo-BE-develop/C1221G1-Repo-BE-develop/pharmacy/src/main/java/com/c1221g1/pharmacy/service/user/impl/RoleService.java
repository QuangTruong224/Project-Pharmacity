package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.repository.user.IRoleRepository;
import com.c1221g1.pharmacy.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Roles findRoleByName(String roleUser) {
        return this.iRoleRepository.findRolesByRoleName(roleUser);

    }

    @Override
    public void saveRole(Roles roles) {
        this.iRoleRepository.save(roles);
    }
}
