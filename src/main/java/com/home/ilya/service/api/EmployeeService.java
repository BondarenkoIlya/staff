package com.home.ilya.service.api;

import com.home.ilya.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    boolean createEmployee(Employee employee);

    boolean updateEmployee(Long id, Employee employee);

    boolean deleteEmployeeById(Long id);
}
