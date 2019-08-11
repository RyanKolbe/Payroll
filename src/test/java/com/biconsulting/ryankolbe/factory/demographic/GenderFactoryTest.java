package com.biconsulting.ryankolbe.factory.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void createGender() {
        Gender gender = GenderFactory.createGender("001", "Male");
        Assert.assertEquals("Male", gender.getGenderDescr());
    }
}