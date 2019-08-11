package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.factory.employee.EmployeeGenderFactory;
import com.biconsulting.ryankolbe.repository.employee.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpTest {
    private static EmployeeGenderRepository employeeGenderRepository = EmployeeGenderRepositoryImp.getEmployeeGenderRepository();
    private static Set<EmployeeGender> employeeGenders = new HashSet<>();
    private static EmployeeGender employeeGender;

    @BeforeClass
    public static void setUp() {
        employeeGender = EmployeeGenderFactory.createEmployeeGender("0001", "Ryan",
                "Kolbe", "0001", "Male");
        employeeGenders.add(employeeGenderRepository.create(employeeGender));
    }

    @Test
    public void getEmployeeGenderRepository() {
        Assert.assertNotNull(employeeGenderRepository);
    }

    @Test
    public void getAll() {
        Set<EmployeeGender> employeeGenderSet = employeeGenderRepository.getAll();
        Assert.assertEquals(employeeGenderSet, employeeGenderRepository.getAll());
    }

    @Test
    public void create() {
        EmployeeGender createEmployeeGender = EmployeeGenderFactory.createEmployeeGender("0002",
                "Deidre", "Van Vuuren", "0002", "Female");
        employeeGenders.add(employeeGenderRepository.create(createEmployeeGender));
        Assert.assertEquals(createEmployeeGender, employeeGenderRepository.read(createEmployeeGender.getEmpNumber()));
    }

    @Test
    public void read() {
        EmployeeGender readEmployeeGender = employeeGenderRepository.getAll().iterator().next();
        Assert.assertEquals(readEmployeeGender, employeeGenderRepository.read(readEmployeeGender.getEmpNumber()));
    }

    @Test
    public void update() {
        String newLastName = "Doofus";
        EmployeeGender updateEmployeeGender = new EmployeeGender.Builder()
                .copy(employeeGender)
                .empLastName(newLastName)
                .build();
        employeeGenders.add(employeeGenderRepository.update(updateEmployeeGender));
        Assert.assertEquals(updateEmployeeGender, employeeGenderRepository.read(updateEmployeeGender.getEmpNumber()));

    }

    @Test
    public void delete() {
    }
}