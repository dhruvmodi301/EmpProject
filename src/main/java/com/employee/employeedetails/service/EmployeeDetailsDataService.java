package com.employee.employeedetails.service;

import com.employee.employeedetails.dto.EmployeeRequest;
import com.employee.employeedetails.entity.EmployeeDetailsData;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface EmployeeDetailsDataService {

    EmployeeDetailsData create(EmployeeRequest employeeRequest);

    EmployeeDetailsData getById(Integer id);

    DataTablesOutput<EmployeeDetailsData> getAllEmployeeDetails(DataTablesInput dataTablesInput);

    EmployeeDetailsData update(EmployeeRequest employeeRequest);

    void delete(Integer id);
}