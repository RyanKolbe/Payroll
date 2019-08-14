package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.factory.employee.EmployeeFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class EmployeeServiceImplTest {
    private static EmployeeServiceImpl employeeService = EmployeeServiceImpl.getEmployeeService();
    private static Employee employee;

    @BeforeClass
    public static void setUp() {
        employee = employeeService.create(EmployeeFactory.createEmployee("0001",
                "Ryan", "Kolbe"));
        employeeService.create(employee);
    }

    @Test
    public void getEmployeeService() {
        Assert.assertNotNull(employeeService);
    }

    @Test
    public void create() {
        Employee createEmployee = employeeService.create(EmployeeFactory.createEmployee("0002",
                "Deidre", "Van Vuuren"));
        Assert.assertEquals(createEmployee, employeeService.read(createEmployee.getEmpNumber()));
    }

    @Test
    public void read() {
        Employee readEmployee = employeeService.read(retrieve().getEmpNumber());
        Assert.assertEquals(readEmployee, employeeService.read(readEmployee.getEmpNumber()));
    }

    @Test
    public void update() {
        String newEmpName = "Cassidy";
        Employee updateEmployee = new Employee.Builder()
                .copy(employee).empFirstName(newEmpName).build();
        employeeService.update(updateEmployee);
        Assert.assertEquals(newEmpName, employeeService.read(updateEmployee.getEmpNumber()).getEmpFirstName());
    }

    @Test
    public void delete() {
        Employee deleteEmployee = employeeService.create(EmployeeFactory.createEmployee("0004",
                "John", "Doe"));
        employeeService.delete(deleteEmployee.getEmpNumber());
        Assert.assertFalse(employeeService.getAll()
                .iterator()
                .next()
                .getEmpNumber()
                .contains("0004"));
    }

    @Test
    public void getAll() {
        Set<Employee> employeeSet = employeeService.getAll();
        Assert.assertEquals(employeeSet.size(), employeeService.getAll().size());
    }

    private Employee retrieve() {
        return employeeService.getAll().iterator().next();
    }
}