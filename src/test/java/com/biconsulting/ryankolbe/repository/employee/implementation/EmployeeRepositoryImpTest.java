package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.factory.employee.EmployeeFactory;
import com.biconsulting.ryankolbe.repository.employee.EmployeeRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpTest {
    private static EmployeeRepository employeeRepository = EmployeeRepositoryImp.getEmployeeRepository();
    private static Set<Employee> employees = new HashSet<>();
    private static Employee employee;

    @BeforeClass
    public static void setUp() {
        employee = EmployeeFactory.createEmployee("0001", "Ryan", "Kolbe");
        employees.add(employeeRepository.create(employee));
    }

    @Test
    public void getEmployeeRepository() {
        Assert.assertNotNull(employeeRepository);
    }

    @Test
    public void getAll() {
        Set<Employee> employeeSet = employeeRepository.getAll();
        Assert.assertEquals(employeeSet.size(), employeeRepository.getAll().size());
    }

    @Test
    public void create() {
        Employee createEmployee = EmployeeFactory.createEmployee("0002",
                "Deidre", "Van Vuuren");
        employees.add(employeeRepository.create(createEmployee));
        Assert.assertEquals(createEmployee, employeeRepository.read(createEmployee.getEmpNumber()));
    }

    @Test
    public void read() {
        Employee readEmployee = employeeRepository.getAll().iterator().next();
        Assert.assertEquals(readEmployee, employeeRepository.read(readEmployee.getEmpNumber()));
    }

    @Test
    public void update() {
        String newLastName = "Kolbe";
        Employee updateEmployee = new Employee.Builder().copy(employee).empLastName(newLastName).build();
        employees.add(employeeRepository.update(updateEmployee));
        Assert.assertEquals(updateEmployee, employeeRepository.read(updateEmployee.getEmpNumber()));
    }

    @Test
    public void delete() {
        Employee deleteEmployee = EmployeeFactory.createEmployee("0003",
                "Cassidy", "Van Vuuren");
        employees.add(employeeRepository.create(deleteEmployee));
        employees.remove(deleteEmployee);
        employeeRepository.delete(deleteEmployee.getEmpNumber());
        Assert.assertEquals(employees.size(), employeeRepository.getAll().size());
        System.out.println(employeeRepository.getAll().toString());
        Assert.assertFalse(employeeRepository.getAll()
                .iterator()
                .next()
                .getEmpFirstName()
                .contains("Cassidy"));
    }
}