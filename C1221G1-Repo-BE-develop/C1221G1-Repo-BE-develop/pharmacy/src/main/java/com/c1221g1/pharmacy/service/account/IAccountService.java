package com.c1221g1.pharmacy.service.account;

import com.c1221g1.pharmacy.dto.account.IAccountEmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    List<IAccountEmployeeDto> findAllAccount();

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    void updateAccount(String password, Integer position, String id);

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    IAccountEmployeeDto findAccountId(String id);


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    Page<IAccountEmployeeDto> findAndSearchAccount(
            String id,
            String name,
            String position,
            String username,
            Pageable pageable);


}
