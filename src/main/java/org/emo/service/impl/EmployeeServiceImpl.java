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
import java.util.Optional;

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

    @Override
    public void updareEmployee(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(employee,EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {
        if(repository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId= repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(),Employee.class);

        }
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String firstName) {
       return new ObjectMapper().convertValue(repository.findByFirstName(firstName),Employee.class);

    }
}
