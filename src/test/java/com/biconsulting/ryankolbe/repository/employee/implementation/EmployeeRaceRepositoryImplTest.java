package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.factory.employee.EmployeeRaceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImplTest {
    private static EmployeeRaceRepositoryImpl employeeRaceRepository = EmployeeRaceRepositoryImpl.getEmployeeRaceRepository();
    private static Set<EmployeeRace> employeeRaces = new HashSet<>();
    private static EmployeeRace employeeRace;

    @BeforeClass
    public static void setUp() {
        employeeRace = EmployeeRaceFactory.createEmployeeRace("0001", "Ryan",
                "Kolbe", "0001", "Coloured");
        employeeRaces.add(employeeRaceRepository.create(employeeRace));
    }

    @Test
    public void getEmployeeRaceRepository() {
        Assert.assertNotNull(employeeRaceRepository);
    }

    @Test
    public void getAll() {
        Set<EmployeeRace> employeeRaceSet = employeeRaceRepository.getAll();
        Assert.assertEquals(employeeRaceSet, employeeRaceRepository.getAll());
    }

    @Test
    public void create() {
        EmployeeRace createEmployeeRace = EmployeeRaceFactory.createEmployeeRace("0002",
                "Deidre", "Van Vuuren", "0002", "Black");
        employeeRaces.add(employeeRaceRepository.create(createEmployeeRace));
        Assert.assertEquals(createEmployeeRace, employeeRaceRepository.read(createEmployeeRace.getEmpNumber()));
    }

    @Test
    public void read() {
        EmployeeRace readEmployeeRace = employeeRaceRepository.read(employeeRaceRepository.getAll()
                .iterator().next().getEmpNumber());
        Assert.assertEquals(readEmployeeRace, employeeRaceRepository.read(readEmployeeRace.getEmpNumber()));
    }

    @Test
    public void update() {
        String newRace = "Chinese";
        EmployeeRace updateEmployeeRace = new EmployeeRace.Builder().copy(employeeRace).raceDesc(newRace).build();
        employeeRaces.add(employeeRaceRepository.update(updateEmployeeRace));
        Assert.assertEquals(updateEmployeeRace, employeeRaceRepository.read(updateEmployeeRace.getEmpNumber()));
    }

    @Test
    public void delete() {
        EmployeeRace deleteEmployeeRace = EmployeeRaceFactory.createEmployeeRace("0003",
                "Cassidy", "Van Vuuren", "0004", "Asian");
        employeeRaces.add(employeeRaceRepository.create(deleteEmployeeRace));
        employeeRaces.remove(deleteEmployeeRace);
        employeeRaceRepository.delete(deleteEmployeeRace.getEmpNumber());
        Assert.assertEquals(employeeRaces.size(), employeeRaceRepository.getAll().size());
        Assert.assertFalse(employeeRaceRepository.getAll()
                .iterator()
                .next()
                .getRaceDesc()
                .contains("Asian"));
    }
}