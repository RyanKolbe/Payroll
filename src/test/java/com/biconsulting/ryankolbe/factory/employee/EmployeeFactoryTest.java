package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeFactoryTest {

    @Test
    public void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee("Ryan", "Kolbe");
        Assert.assertEquals("Ryan", employee.getEmpFirstName());
    }
}