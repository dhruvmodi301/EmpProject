package com.employee.employeedetails.controller;

import com.employee.employeedetails.dto.EmployeeRequest;
import com.employee.employeedetails.entity.EmployeeDetailsData;
import com.employee.employeedetails.service.EmployeeDetailsDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDetailsDataService service;

    @GetMapping("/home")
    public String home() {
        return "employee";
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        log.debug("Inside createEmployee employeeRequest: {}", employeeRequest);
        EmployeeDetailsData entity = service.create(employeeRequest);
        log.debug("Leaving createEmployee saved employee data: {}", entity);
        return "employee";
    }

    @ResponseBody
    @PostMapping("/get-all")
    public DataTablesOutput<EmployeeDetailsData> getAllEmployees(@RequestBody DataTablesInput dataTablesInput) {
        log.debug("Inside getAllEmployees dataTablesInput: {}", dataTablesInput);
        return service.getAllEmployeeDetails(dataTablesInput);
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
        log.debug("Inside updateEmployee employeeRequest: {}", employeeRequest);
        EmployeeDetailsData entity = service.update(employeeRequest);
        log.debug("Leaving updateEmployee updated employee data: {}", entity);
        return "employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id) {
        log.debug("Inside deleteEmployee employeeId: {}", id);
        service.delete(id);
        log.debug("Leaving deleteEmployee");
        return "employee";
    }

    @GetMapping("/create-emp")
    public String navigateCreate() {
        return "employee_create";
    }

    @GetMapping("/get-by-id")
    public String getEmployee(@RequestParam Integer id, Model model) {
        EmployeeDetailsData data = service.getById(id);
        model.addAttribute("data", data);
        return "employee_edit";
    }
}