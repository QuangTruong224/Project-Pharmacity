package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRoleRepository extends JpaRepository<Roles,Integer> {
    /**
     *
     * HuuNQ Created
     * Time : 01/07/2022 16:00
     * This method get Role from database
     */
    @Query(value="select * from roles where role_name = :roleName",nativeQuery=true)
    Roles findRolesByRoleName(@Param("roleName") String string);
}
