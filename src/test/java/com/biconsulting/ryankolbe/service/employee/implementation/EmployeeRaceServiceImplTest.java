package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.factory.employee.EmployeeRaceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class EmployeeRaceServiceImplTest {
    private static EmployeeRaceServiceImpl employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();
    private static EmployeeRace employeeRace;

    @BeforeClass
    public static void setUp() {
        employeeRace = EmployeeRaceFactory.createEmployeeRace("0001", "Ryan",
                "Kolbe", "0001", "Coloured");
        employeeRaceService.create(employeeRace);
    }

    @Test
    public void getEmployeeRaceService() {
        Assert.assertNotNull(employeeRaceService);
    }

    @Test
    public void create() {
        EmployeeRace createEmployeeRace = employeeRaceService.create(
                EmployeeRaceFactory.createEmployeeRace("0002", "Deidre",
                        "Van Vuuren", "0001", "Black"));
        Assert.assertEquals(createEmployeeRace, employeeRaceService.read(createEmployeeRace.getEmpNumber()));
    }

    @Test
    public void read() {
        EmployeeRace readEmployeeRace = employeeRaceService.read(retrieve().getEmpNumber());
        Assert.assertEquals(readEmployeeRace, employeeRaceService.read(readEmployeeRace.getEmpNumber()));
    }

    @Test
    public void update() {
        String newEmpRace = "Asian";
        EmployeeRace updateEmployeeRace = new EmployeeRace.Builder()
                .copy(employeeRace).raceDesc(newEmpRace).build();
        employeeRaceService.update(updateEmployeeRace);
        Assert.assertEquals(newEmpRace, employeeRaceService.read(updateEmployeeRace.getEmpNumber())
                .getRaceDesc());
    }

    @Test
    public void delete() {
        EmployeeRace deleteEmployeeRace = employeeRaceService.create(
                EmployeeRaceFactory.createEmployeeRace("0005", "John",
                        "Doe", "0006", "Unknown"));
        employeeRaceService.delete(deleteEmployeeRace.getEmpNumber());
        Assert.assertFalse(employeeRaceService.getAll()
                .iterator()
                .next()
                .getRaceDesc()
                .contains("Unknown"));
    }

    @Test
    public void getAll() {
        Set<EmployeeRace> employeeRaceSet = employeeRaceService.getAll();
        Assert.assertEquals(employeeRaceSet.size(), employeeRaceService.getAll().size());
    }

    private EmployeeRace retrieve() {
        return employeeRaceService.getAll().iterator().next();
    }
}