package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.factory.employee.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class EmployeeGenderServiceImplTest {
    private static EmployeeGenderServiceImpl employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
    private static EmployeeGender employeeGender;

    @BeforeClass
    public static void setUp() {
        employeeGender = employeeGenderService.create(
                EmployeeGenderFactory.createEmployeeGender("0001", "Ryan", "Kolbe"
                        , "0001", "Coloured"));
        employeeGenderService.create(employeeGender);
    }

    @Test
    public void getEmployeeGenderService() {
        Assert.assertNotNull(employeeGenderService);
    }

    @Test
    public void create() {
        EmployeeGender createEmployeeGender = employeeGenderService.create(
                EmployeeGenderFactory.createEmployeeGender("0002", "Deidre",
                        "Van Vuuren", "0002", "Female"));
        Assert.assertEquals(createEmployeeGender, employeeGenderService.read(createEmployeeGender.getEmpNumber()));
    }

    @Test
    public void read() {
        EmployeeGender readEmployeeGender = employeeGenderService.read(retrieve().getEmpNumber());
        Assert.assertEquals(readEmployeeGender, employeeGenderService.read(readEmployeeGender.getEmpNumber()));
    }

    @Test
    public void update() {
        String newGender = "Unknown";
        EmployeeGender updateEmployeeGender = new EmployeeGender.Builder().copy(employeeGender)
                .genderDesc(newGender).build();
        employeeGenderService.update(updateEmployeeGender);
        Assert.assertEquals(updateEmployeeGender, employeeGenderService.read(updateEmployeeGender.getEmpNumber()));
    }

    @Test
    public void delete() {
        EmployeeGender deleteEmployeeGender = employeeGenderService.create(
                EmployeeGenderFactory.createEmployeeGender("0003", "Cassidy",
                        "Van Vuuren", "0003", "Unknown"));
        employeeGenderService.delete(deleteEmployeeGender.getEmpNumber());
        Assert.assertFalse(employeeGenderService.getAll().iterator()
                .next()
                .getGenderDesc()
                .contains("Unknown"));
    }

    @Test
    public void getAll() {
        Set<EmployeeGender> employeeGenderSet = employeeGenderService.getAll();
        Assert.assertEquals(employeeGenderSet.size(), employeeGenderService.getAll().size());
    }

    private EmployeeGender retrieve() {
        return employeeGenderService.getAll().iterator().next();
    }
}