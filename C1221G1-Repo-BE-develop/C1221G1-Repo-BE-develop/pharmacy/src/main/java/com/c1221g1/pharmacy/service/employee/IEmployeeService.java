package com.c1221g1.pharmacy.service.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getList();

    /**
     * this function use to get all page Employee
     *
     * @author GiangTB
     * @Time 15:30 29/06/2022
     */
    Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal, String positionVal, String employeeAddressVal, String employeePhoneVal, Pageable pageable);

    /**
     * this function use to find Employee by id
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    Employee findEmployeeById(String id);

    /**
     * this function use to delete employee from page (not delete in database)
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    void deleteEmployeeById(String id);

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:00 29/06/2022
     */
    List<Employee> getListEmployee();

    /*
      Created by TamNA
      Time: 13:35:00 01/07/2022
      Function: Save Emoloyee
    */
    void saveEmployee(Employee employee);

    /*
      Created by TamNA
      Time: 13:35:00 01/07/2022
      Function: Update Emoloyee
    */
    void updateEmployee(Employee employee);
}
