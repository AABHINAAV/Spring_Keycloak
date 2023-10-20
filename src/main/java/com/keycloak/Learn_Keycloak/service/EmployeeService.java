package com.keycloak.Learn_Keycloak.service;

import com.keycloak.Learn_Keycloak.model.Employee;
import com.keycloak.Learn_Keycloak.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(int empId) {
        return this.employeeRepository
                .findById(Integer.valueOf(empId))
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }
}
