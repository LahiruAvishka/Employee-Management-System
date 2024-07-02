package org.emo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emo.dto.Employee;
import org.emo.entity.EmployeeEntity;
import org.emo.repository.EmployeeRepository;
import org.emo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {




   final EmployeeRepository repository;
    @Override
    public void addEmployee(Employee employee) {

        EmployeeEntity employeeEntity=new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }
    @Override
    public List<EmployeeEntity> getAll() {

        return repository.findAll();
    }
}
