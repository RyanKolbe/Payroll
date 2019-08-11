package com.biconsulting.ryankolbe.repository.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.factory.demographic.GenderFactory;
import com.biconsulting.ryankolbe.repository.demographic.GenderRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpTest {
    private static GenderRepository genderRepository = GenderRepositoryImp.getGenderRepository();
    private static Set<Gender> genders = new HashSet<>();
    private static Gender gender;

    @BeforeClass
    public static void setUp() {
        gender = GenderFactory.createGender("0001", "Male");
        genders.add(genderRepository.create(gender));
    }

    @Test
    public void getGenderRepository() {
        Assert.assertNotNull(genderRepository);
    }

    @Test
    public void getAll() {
        Set<Gender> genderSet = genderRepository.getAll();
        Assert.assertEquals(genderSet.size(), genderRepository.getAll().size());
    }

    @Test
    public void create() {
        Gender createGender = GenderFactory.createGender("0002", "Female");
        genders.add(genderRepository.create(createGender));
        Assert.assertEquals(createGender.getGenderDescr(),
                genderRepository.read(createGender.getGenderId()).getGenderDescr());
    }

    @Test
    public void read() {
        Gender readGender = genderRepository.getAll().iterator().next();
        Assert.assertEquals(readGender.getGenderId(),
                genderRepository.read(readGender.getGenderId()).getGenderId());
    }

    @Test
    public void update() {
        String newGender = "Female";
        Gender updateGender = new Gender.Builder().copy(gender).genderDesc(newGender).build();
        genders.add(genderRepository.update(updateGender));
        Assert.assertEquals(newGender, genderRepository.read(updateGender.getGenderId()).getGenderDescr());
    }

    @Test
    public void delete() {
        Gender deleteGender = GenderFactory.createGender("0003","Unknown");
        genders.add(genderRepository.create(deleteGender));
        genders.remove(deleteGender);
        genderRepository.delete(deleteGender.getGenderId());
        Assert.assertEquals(genders.size(), genderRepository.getAll().size());
        Assert.assertFalse(genderRepository.getAll()
                .iterator()
                .next()
                .getGenderDescr()
                .contains("Unknown"));
    }
}