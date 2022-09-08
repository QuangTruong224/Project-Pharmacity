package com.c1221g1.pharmacy.service.account.impl;

import com.c1221g1.pharmacy.dto.account.IAccountEmployeeDto;
import com.c1221g1.pharmacy.repository.account.IAccountRepository;
import com.c1221g1.pharmacy.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    @Override
    public List<IAccountEmployeeDto> findAllAccount() {
        return iAccountRepository.findAllAccount();
    }

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    @Override
    public void updateAccount(String password, Integer position, String id) {
        iAccountRepository.updateAccount(password, position, id);
    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    @Override
    public IAccountEmployeeDto findAccountId(String id) {
        return iAccountRepository.findByAccountId(id);
    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @Override
    public Page<IAccountEmployeeDto> findAndSearchAccount(String id, String name, String position, String username, Pageable pageable) {
        return iAccountRepository.findAndSearchAccount(id, name, position, username, pageable);
    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
//    @Override
//    public Page<IAccountEmployeeDto> findAndSearchAccount2(String id, String name, String username, Pageable pageable) {
//        return iEmployeeRepository.findAndSearchAccount2(id, name, username, pageable);
//    }
}
