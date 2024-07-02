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
    public List<Employee> getAll() {
        List<Employee> employeeslist = new ArrayList<>();
        List<EmployeeEntity> allEntityList=repository.findAll();
        allEntityList.forEach(entity ->{
            employeeslist.add(new ObjectMapper().convertValue(entity, Employee.class));
        });

        return employeeslist;
    }

    @Override
    public void deleteEmployeeById() {

    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }

    }
}
