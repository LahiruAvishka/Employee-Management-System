package org.emo.employeeController;

import lombok.RequiredArgsConstructor;
import org.emo.dto.Employee;
import org.emo.entity.EmployeeEntity;
import org.emo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")

@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService service;
    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);

    }
    @GetMapping("get-all")
    public List<EmployeeEntity> getAll(){
       return service.getAll();
    }
}
