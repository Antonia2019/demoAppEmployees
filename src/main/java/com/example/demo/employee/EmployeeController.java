package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId,
                               @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
