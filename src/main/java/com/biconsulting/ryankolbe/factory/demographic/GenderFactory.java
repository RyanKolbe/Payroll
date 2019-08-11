package com.biconsulting.ryankolbe.factory.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Gender;

public class GenderFactory {
    public static Gender createGender(String genderId, String genderDesc) {
        return new Gender.Builder()
                .genderId(genderId)
                .genderDesc(genderDesc)
                .build();
    }
}
