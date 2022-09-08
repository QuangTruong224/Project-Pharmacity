package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {

    /**
     * this function use to get all page Employee
     *
     * @author GiangTB
     * @Time 15:30 29/06/2022
     */
    @Query(value="select employee_id,employee_address,employee_date_start,\n" +
            "       employee_image,employee_name,employee_note,\n" +
            "       employee_phone,position_id,username,flag\n" +
            "from c1221g1_pharmacy.employee where employee_id like :employeeIdVal \n" +
            "                                 and employee_name like :employeeNameVal \n" +
            "                                 and position_id like :positionVal \n" +
            "                                 and employee_phone like :employeePhoneVal \n" +
            "                                 and employee_address like :employeeAddressVal \n" +
            "                                 and flag = 1",
    countQuery= "select employee_id,employee_address,employee_date_start,\n" +
            "       employee_image,employee_name,employee_note,\n" +
            "       employee_phone,position_id,username,flag\n" +
            "from c1221g1_pharmacy.employee where employee_id like :employeeIdVal \n" +
            "                                 and employee_name like :employeeNameVal \n" +
            "                                 and position_id like :positionVal \n" +
            "                                 and employee_phone like :employeePhoneVal \n" +
            "                                 and employee_address like :employeeAddressVal \n" +
            "                                 and flag = 1", nativeQuery = true)
    Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal,
                                  String positionVal, String employeeAddressVal,
                                  String employeePhoneVal, Pageable pageable);

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Query(value = "select employee_address,employee_phone,employee_name," +
            "employee_id,employee_note,employee_image,employee_date_start,username,position_id,flag\n" +
            "from employee where employee_id = :id",nativeQuery=true)
    Employee findEmployeeById(String id);


    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value="UPDATE employee set flag = 0 where employee_id = :id ", nativeQuery=true)
    void deleteEmployeeById(String id);


    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:30 29/06/2022
     */
    @Query(value = "select employee_id, employee_date_start,employee_image," +
            "employee_note,employee_name,employee_name,employee_phone," +
            "employee_address,position_id,username,flag from employee",nativeQuery=true)
    List<Employee> getListEmployee();

    
/*
  Created by TamNA
  Time: 13:35:00 01/07/2022
  Function:  SQL Update Emoloyee
*/
    @Transactional
    @Modifying
    @Query(value = "update employee set employee_name = :employeeName, employee_image = :employeeImage ,employee_address = :employeeAddress," +
            ":employee_phone = :employeePhone , employee_date_start = :employeeDateStart,employee_note = :employeeNote," +
            "position_id = :position,username = :employeeUsername where employee_id = :employeeId", nativeQuery = true)
    void updateEmployee(
            @Param("employeeName") String employeeName,
            @Param("employeeImage") String employeeImage,
            @Param("employeeAddress") String employeeAddress,
            @Param("employeePhone") String employeePhone,
            @Param("employeeDateStart") String employeeDateStart,
            @Param("employeeNote") String employeeNote,
            @Param("position") Position position,
            @Param("employeeUsername") Users employeeUsername,
            @Param("employeeId") String employeeId);
}
