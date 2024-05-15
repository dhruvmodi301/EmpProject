package com.employee.employeedetails.repository;

import com.employee.employeedetails.entity.AccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends JpaRepository<AccountData, Long> {

    AccountData findByUsername(String username);
}