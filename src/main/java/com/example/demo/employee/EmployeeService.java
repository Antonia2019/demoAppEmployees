package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {       // READ
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee){ // CREATE*
        employeeRepository.saveAndFlush(employee);
    }

    @Transactional
    public void updateEmployee(Long id, Employee employee) {  // UPDATE*
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("employee with id "+ id + " doesn't exist"));

        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setSalary(employee.getSalary());
        employeeToUpdate.setDesignation(employee.getDesignation());

        employeeRepository.save(employeeToUpdate);
    }
    public void deleteEmployee(Long employeeId) {  // DELETE
        employeeRepository.deleteById(employeeId);
    }

}
