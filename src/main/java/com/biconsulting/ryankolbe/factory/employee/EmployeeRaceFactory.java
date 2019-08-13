package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;

public class EmployeeRaceFactory {
    public static EmployeeRace createEmployeeRace(String empNumber, String empFirstName, String empLastName,
                                                  String raceId, String raceDesc) {
        return new EmployeeRace.Builder()
                .empNumber(empNumber)
                .empFirstName(empFirstName)
                .empLastName(empLastName)
                .raceId(raceId)
                .raceDesc(raceDesc)
                .build();
    }
}
