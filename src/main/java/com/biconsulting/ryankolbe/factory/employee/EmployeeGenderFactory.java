package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;

public class EmployeeGenderFactory {
    public static EmployeeGender createEmployeeGender(String empNumber, String empFirstName, String empLastName, String genderId,
                                                      String genderDesc) {
        return new EmployeeGender.Builder()
                .empNumber(empNumber)
                .empFirstName(empFirstName)
                .empLastName(empLastName)
                .genderId(genderId)
                .genderDesc(genderDesc)
                .build();
    }
}
