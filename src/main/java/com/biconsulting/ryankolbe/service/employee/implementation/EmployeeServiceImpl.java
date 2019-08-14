package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.repository.employee.EmployeeRepository;
import com.biconsulting.ryankolbe.repository.employee.implementation.EmployeeRepositoryImp;
import com.biconsulting.ryankolbe.service.employee.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl employeeService = null;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl() {
        this.employeeRepository = EmployeeRepositoryImp.getEmployeeRepository();
    }

    public static EmployeeServiceImpl getEmployeeService() {
        if (employeeService == null) employeeService = new EmployeeServiceImpl();
        return employeeService;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return employeeRepository.read(employeeId);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public void delete(String employeeId) {
        employeeRepository.delete(employeeId);
    }

    @Override
    public Set<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
