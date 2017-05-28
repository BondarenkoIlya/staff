package com.home.ilya.service.impl;

import com.home.ilya.model.Employee;
import com.home.ilya.repository.EmployeeRepository;
import com.home.ilya.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public boolean createEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee) != null;
    }

    @Override
    public boolean updateEmployee(Long id, Employee employee) {
        if (employeeRepository.findOne(id) != null) {
            employee.setId(id);
            employeeRepository.saveAndFlush(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.findOne(id) != null) {
            employeeRepository.delete(id);
            return true;
        }
        return false;
    }
}
