package com.home.ilya.controller;

import com.home.ilya.model.Employee;
import com.home.ilya.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/*")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity postEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/employee/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).body(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity putEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        if (employeeService.updateEmployee(id, employee)) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/employees")
                .build()
                .toUri();

        return ResponseEntity.noContent().location(location).build();
    }
}
