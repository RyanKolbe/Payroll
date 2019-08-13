package com.biconsulting.ryankolbe.service.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.factory.demographic.GenderFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class GenderServiceImpTest {
    private static GenderServiceImp genderService = GenderServiceImp.getGenderService();
    private static Gender gender;

    @BeforeClass
    public static void setUp() {
        gender = GenderFactory.createGender("0001", "Male");
        genderService.create(gender);
    }

    @Test
    public void getGenderService() {
        Assert.assertNotNull(genderService);
    }

    @Test
    public void create() {
        Gender createGender = genderService.create(
                GenderFactory.createGender("0002", "Female"));
        Assert.assertEquals(createGender, genderService.read(createGender.getGenderId()));
    }

    @Test
    public void read() {
        Gender readGender = genderService.read(retrieve().getGenderId());
        Assert.assertEquals(readGender, genderService.read(readGender.getGenderId()));
    }

    @Test
    public void update() {
        String newGenderDesc = "Unknown";
        Gender updateGender = genderService.update(new Gender.Builder().copy(gender)
                .genderDesc(newGenderDesc).build());
        Assert.assertEquals(updateGender, genderService.read(updateGender.getGenderId()));
    }

    @Test
    public void delete() {
        Gender deleteGender = genderService.create(
                GenderFactory.createGender("0002", "Female"));
        genderService.delete(deleteGender.getGenderId());
        Assert.assertFalse(genderService.getAll()
                .iterator().next()
                .getGenderDescr()
                .contains("Female"));
    }

    @Test
    public void getAll() {
        Set<Gender> genderSet = genderService.getAll();
        Assert.assertEquals(genderSet, genderService.getAll());
    }

    private Gender retrieve() {
        return genderService.getAll().iterator().next();
    }
}