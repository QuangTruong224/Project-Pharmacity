package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.user.UserRole;

import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * Created by: TrungTVH
     * Date created: 5/7/2022
     * function: get medicine list dùng tạm
     */
    @Override
    public List<Employee> getList() {
        return this.iEmployeeRepository.findAll();
    }

    /**
     * this function use to get all page Employee
     *
     * @author GiangTB
     * @Time 15:30 29/06/2022
     */
    public Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal,
                                         String positionVal, String employeeAddressVal, String employeePhoneVal, Pageable pageable) {
        return this.iEmployeeRepository.getAllEmployee(
                "%" + employeeIdVal + "%",
                "%" + employeeNameVal + "%",
                "%" + positionVal + "%",
                "%" + employeeAddressVal + "%",
                "%" + employeePhoneVal + "%", pageable);
    }

    /**
     * this function use to find Employee by id
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Override
    public Employee findEmployeeById(String id) {
        return this.iEmployeeRepository.findEmployeeById(id);
    }

    /**
     * this function use to delete employee from page (not delete database)
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Override
    public void deleteEmployeeById(String id) {
        this.iEmployeeRepository.deleteEmployeeById(id);
    }


    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:00 29/06/2022
     */
    @Override
    public List<Employee> getListEmployee() {
        return this.iEmployeeRepository.getListEmployee();
    }
/*
  Created by TamNA
  Time: 13:35:00 01/07/2022
  Function: Save Emoloyee
*/

    @Override
    public void saveEmployee(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }
/*
  Created by TamNA
  Time: 13:35:00 01/07/2022
  Function:  Update Emoloyee
*/

    @Override
    public void updateEmployee(Employee employee) {
        this.iEmployeeRepository.updateEmployee(employee.getEmployeeName(), employee.getEmployeeImage(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeDateStart(), employee.getEmployeeNote(), employee.getPosition(), employee.getEmployeeUsername(), employee.getEmployeeId());
    }
}
