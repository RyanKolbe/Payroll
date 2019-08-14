package com.biconsulting.ryankolbe.controller;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.service.employee.implementation.EmployeeGenderServiceImpl;
import com.biconsulting.ryankolbe.service.employee.implementation.EmployeeRaceServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeControllerTest {
    private static EmployeeController employeeController = new EmployeeController();
    private Employee employee;
    private EmployeeGenderServiceImpl employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
    private EmployeeRaceServiceImpl employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();

    @BeforeClass
    public static void setUp() {
        employeeController = new EmployeeController();
    }

    @Test
    public void createEmployee() {
        employee = employeeController.createEmployee("Ryan", "Kolbe", "Male", "Coloured");
        Assert.assertNotNull(employee);
        System.out.println(employee);
        String empNumber = employee.getEmpNumber();
        System.out.println(empNumber);
        System.out.println(employeeGenderService.read(empNumber));
        System.out.println(employeeRaceService.read(empNumber));
        Assert.assertEquals("Ryan", employee.getEmpFirstName());
        Assert.assertEquals("Male", employeeGenderService.read(empNumber).getGenderDesc());
        Assert.assertEquals("Coloured", employeeRaceService.read(empNumber).getRaceDesc());
    }
}