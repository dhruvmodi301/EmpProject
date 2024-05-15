package com.employee.employeedetails.repository;

import com.employee.employeedetails.entity.EmployeeDetailsData;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsDataRepository extends JpaRepository<EmployeeDetailsData, Integer>, DataTablesRepository<EmployeeDetailsData, Integer> {
}