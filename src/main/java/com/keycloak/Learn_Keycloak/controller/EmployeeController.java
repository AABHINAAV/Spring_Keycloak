package com.keycloak.Learn_Keycloak.controller;

import com.keycloak.Learn_Keycloak.model.Employee;
import com.keycloak.Learn_Keycloak.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(this.employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{empId}")
//    @RolesAllowed("user")         // to give single role access
    @RolesAllowed({"user", "admin"})        // multiple role access
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
        return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(empId), HttpStatus.OK);
    }
}
