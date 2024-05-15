package com.employee.employeedetails.service.impl;

import com.employee.employeedetails.entity.AccountData;
import com.employee.employeedetails.repository.AccountDataRepository;
import com.employee.employeedetails.service.AccountDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AccountDataServiceImpl implements AccountDataService {

    private final AccountDataRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        AccountData accountData = repository.findByUsername(username);

        if (accountData == null) {
            throw new UsernameNotFoundException(username);
        }

        return accountData;
    }
}