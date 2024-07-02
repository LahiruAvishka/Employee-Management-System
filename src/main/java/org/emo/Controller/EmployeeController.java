package org.emo.Controller;

import lombok.RequiredArgsConstructor;
import org.emo.dto.Employee;
import org.emo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public List<Employee> getAll(){
       return service.getAll();
    }

    @DeleteMapping("delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable  Long id){
        service.deleteEmployeeById();
        return "Deleted";
    }

    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody Employee employee){
        service.updareEmployee(employee);
    }
}
