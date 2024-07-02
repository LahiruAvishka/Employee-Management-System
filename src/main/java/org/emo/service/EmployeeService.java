package org.emo.service;

import org.emo.dto.Employee;
import org.emo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<EmployeeEntity> getAll();

}
