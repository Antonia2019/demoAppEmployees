package com.example.demo.employee;

import com.example.demo.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Objects;

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
    public void updateEmployee(Long id, String name, Long salary, String designation) {  // UPDATE*
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("employee with id "+ id + " doesn't exist"));
        if(name != null && name.length() > 0 && !Objects.equals(employee.getName(),name)) {
            employee.setName(name);
            employee.setSalary(salary);
            employee.setDesignation(designation);
        }
    }
    public void deleteEmployee(Long employeeId) {  // DELETE
        employeeRepository.deleteById(employeeId);
    }

}
