package com.example.demo.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    @PostMapping("/registerEmployee")
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @PutMapping(path = "/update/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) Long salary,
                               @RequestParam(required = false) String designation) {
        employeeService.updateEmployee(employeeId, name, salary, designation);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
