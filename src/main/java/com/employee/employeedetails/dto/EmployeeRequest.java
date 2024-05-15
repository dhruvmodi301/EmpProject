package com.employee.employeedetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRequest {

    private Integer id;
    private String name;
    private String department;
    private String salary;
    private LocalDate dateOfJoining;
    private String email;
    private String contact;
}