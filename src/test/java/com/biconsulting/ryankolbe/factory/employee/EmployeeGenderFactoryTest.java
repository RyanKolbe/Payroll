package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeGenderFactoryTest {

    @Test
    public void createEmployeeGender() {
        EmployeeGender employeeGender = EmployeeGenderFactory.createEmployeeGender("0001",
                "Ryan", "Kolbe", "0001", "Male");
        Assert.assertEquals("Kolbe", employeeGender.getEmpLastName());
    }
}