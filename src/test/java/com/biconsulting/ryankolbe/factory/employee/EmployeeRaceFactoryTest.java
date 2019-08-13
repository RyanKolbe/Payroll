package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeRaceFactoryTest {

    @Test
    public void createEmployeeRace() {
        EmployeeRace employeeRace = EmployeeRaceFactory.createEmployeeRace("0001", "Ryan",
                "Kolbe", "0001", "Male");
        Assert.assertEquals("Ryan", employeeRace.getEmpFirstName());
    }
}