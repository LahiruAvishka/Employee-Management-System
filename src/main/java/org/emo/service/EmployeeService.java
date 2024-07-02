package org.emo.service;

import org.emo.dto.Employee;


import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<Employee> getAll();

    void deleteEmployeeById();

    void deleteEmployeeById(Long id);

    void updareEmployee(Employee employee);

    Employee findById(Long id);

    Employee findByFirstName(String firstName);
}
