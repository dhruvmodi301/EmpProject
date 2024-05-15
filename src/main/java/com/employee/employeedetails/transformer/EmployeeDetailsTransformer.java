package com.employee.employeedetails.transformer;

import com.employee.employeedetails.dto.EmployeeRequest;
import com.employee.employeedetails.entity.EmployeeDetailsData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsTransformer {

    public EmployeeDetailsData toEntity(EmployeeRequest employeeRequest) {
        EmployeeDetailsData employeeDetailsData = new EmployeeDetailsData();
        employeeDetailsData.setName(employeeRequest.getName());
        employeeDetailsData.setSalary(employeeRequest.getSalary());
        employeeDetailsData.setDepartment(employeeRequest.getDepartment());
        employeeDetailsData.setDateOfJoining(employeeRequest.getDateOfJoining());
        employeeDetailsData.setEmail(employeeRequest.getEmail());
        employeeDetailsData.setContact(employeeRequest.getContact());
        return employeeDetailsData;
    }
}