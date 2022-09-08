package com.c1221g1.pharmacy.controller.account;

import com.c1221g1.pharmacy.dto.account.AccountEmployeeDto;
import com.c1221g1.pharmacy.dto.account.IAccountEmployeeDto;
import com.c1221g1.pharmacy.service.account.IAccountService;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-account/account")
public class AccountEmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IAccountService iAccountService;
    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    @GetMapping(value = "/listAccount")
    public ResponseEntity<List<IAccountEmployeeDto>> getListAccount() {
        List<IAccountEmployeeDto> accountEmployees = this.iAccountService.findAllAccount();
        if (accountEmployees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountEmployees, HttpStatus.OK);
    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @GetMapping(value = "")
    public ResponseEntity<Page<IAccountEmployeeDto>> getListAccountPage(
            @PageableDefault(value = 3) Pageable pageable,
            @RequestParam Optional<String> id,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> position,
            @RequestParam Optional<String> username

    ) {

        String nameVal = name.orElse("");
        String idVal = id.orElse("");
        String usernameVal = username.orElse("");
        String positionVal = position.orElse("");
        Page<IAccountEmployeeDto> iAccountEmployeeDtoPage = iAccountService.findAndSearchAccount(idVal, nameVal, positionVal, usernameVal, pageable);
        if (iAccountEmployeeDtoPage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iAccountEmployeeDtoPage, HttpStatus.OK);

    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<IAccountEmployeeDto> findId(@PathVariable("id") String id) {
        IAccountEmployeeDto accountEmployee = iAccountService.findAccountId(id);
        if (accountEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(accountEmployee, HttpStatus.OK);
    }

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    @PatchMapping(value = "/updateAccount")
    public ResponseEntity<Object> updateAccount(
            @RequestParam String id,
            @RequestBody AccountEmployeeDto accountEmployeeDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        IAccountEmployeeDto iAccountEmployeeDto = iAccountService.findAccountId(id);

        if (iAccountEmployeeDto != null) {
            iAccountService.updateAccount(passwordEncoder.encode(accountEmployeeDto.getPassword()), accountEmployeeDto.getPosition().getPositionId(),  id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

}
