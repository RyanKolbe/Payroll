package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.repository.employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImp implements EmployeeRepository {
    private static EmployeeRepositoryImp employeeRepository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImp() {
        employees = new HashSet<>();
    }

    public static EmployeeRepositoryImp getEmployeeRepository() {
        if (employeeRepository == null) employeeRepository = new EmployeeRepositoryImp();
        return employeeRepository;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(String employeeId) {
        return search(employeeId);
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeTemp = search(employee.getEmpNumber());
        if (employeeTemp != null) {
            employees.remove(employeeTemp);
            return create(employee);
        }
        return null;
    }

    @Override
    public void delete(String employeeId) {
        Employee employeeDelete = search(employeeId);
        if (employeeDelete != null) this.employees.remove(employeeDelete);
    }

    private Employee search(final String employeeId) {
        for (Employee employeeSearch : this.employees) {
            if (employeeSearch.getEmpNumber().equals(employeeId))
                return employeeSearch;
        }
        return null;
    }
}