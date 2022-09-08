package com.c1221g1.pharmacy.repository.account;

import com.c1221g1.pharmacy.dto.account.IAccountEmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Employee, String> {
    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    @Query(value = "select employee.employee_name as `employeeName`, employee.employee_id as `employeeId`," +
            " `position`.position_name as `positionName`, employee.username as `username`, users.`password` as `password`\n" +
            "from employee join users  on employee.username =  users.username join `position`  on `position`.position_id = employee.position_id group by employee.employee_id", nativeQuery = true)
    List<IAccountEmployeeDto> findAllAccount();


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    @Query(value = "select employee.employee_name as `employeeName`, employee.employee_id as `employeeId`,\n" +
            " `position`.position_name as `positionName`, employee.username as `username`, users.`password` as `password`\n" +
            "from employee  " +
            " join users  on employee.username =  users.username " +
            " join `position`  on `position`.position_id = employee.position_id " +
            "where employee.employee_id = ? ", nativeQuery = true)
    IAccountEmployeeDto findByAccountId(String id);



    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @Query(value = "select employee.employee_name as `employeeName`, employee.employee_id as `employeeId`," +
            "`position`.position_name as `positionName`, employee.username as `username`, users.`password` as `password`\n" +
            "from employee " +
            "join users  on employee.username =  users.username " +
            "join `position`  on `position`.position_id = employee.position_id " +
            "where employee.employee_id like %:id% " +
            "and employee.employee_name like %:name% " +
            "and `position`.position_name like %:position% " +
            "and employee.username like %:username% ",
            countQuery = "select employee.employee_name as `employeeName`, employee.employee_id as `employeeId`," +
                    " `position`.position_name as `positionName`, employee.username as `username`, users.`password` as `password` " +
                    " from employee " +
                    " join users  on employee.username =  users.username " +
                    " join `position`  on `position`.position_id = employee.position_id" +
                    " where employee.employee_id like %:id%" +
                    " and employee.employee_name like %:name% " +
                    " and `position`.position_name like %:position% " +
                    " and employee.username like %:username%", nativeQuery = true)
    Page<IAccountEmployeeDto> findAndSearchAccount(
            @Param("id") String id,
            @Param("name") String name,
            @Param("position") String position,
            @Param("username") String username,
            Pageable pageable);



    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    @Transactional
    @Modifying
    @Query(value = "update employee  " +
            "join users  on employee.username =  users.username \n" +
            "join `position`  on `position`.position_id = employee.position_id \n" +
            "set `users`.`password` = :password, employee.position_id = :position   where employee.employee_id = :id ", nativeQuery = true)
    void updateAccount(String password, Integer position, @Param("id") String id);

}
