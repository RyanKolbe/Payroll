package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.factory.demographic.GenderFactory;

public class EmployeeGenderFactory {
    public static EmployeeGender createEmployeeGender(String empFirstName, String empLastName, String genderId,
                                                      String genderDesc) {
        return new EmployeeGender.Builder()
                .employee(EmployeeFactory.createEmployee(empFirstName, empLastName))
                .gender(GenderFactory.createGender(genderId, genderDesc))
                .build();
    }
}
