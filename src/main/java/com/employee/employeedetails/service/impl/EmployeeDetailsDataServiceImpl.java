package com.employee.employeedetails.service.impl;

import com.employee.employeedetails.dto.EmployeeRequest;
import com.employee.employeedetails.entity.EmployeeDetailsData;
import com.employee.employeedetails.repository.EmployeeDetailsDataRepository;
import com.employee.employeedetails.service.EmployeeDetailsDataService;
import com.employee.employeedetails.transformer.EmployeeDetailsTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDetailsDataServiceImpl implements EmployeeDetailsDataService {

    private final EmployeeDetailsTransformer transformer;
    private final EmployeeDetailsDataRepository employeeDetailsDataRepository;

    @Override
    public EmployeeDetailsData create(EmployeeRequest employeeRequest) {
        EmployeeDetailsData entity = transformer.toEntity(employeeRequest);
        return employeeDetailsDataRepository.save(entity);
    }

    @Override
    public EmployeeDetailsData getById(Integer id) {
        return employeeDetailsDataRepository.getReferenceById(id);
    }

    @Override
    public DataTablesOutput<EmployeeDetailsData> getAllEmployeeDetails(DataTablesInput dataTablesInput) {
        return employeeDetailsDataRepository.findAll(dataTablesInput);
    }

    @Override
    public EmployeeDetailsData update(EmployeeRequest employeeRequest) {
        EmployeeDetailsData entity = transformer.toEntity(employeeRequest);
        entity.setId(employeeRequest.getId());
        return employeeDetailsDataRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        employeeDetailsDataRepository.deleteById(id);
    }
}