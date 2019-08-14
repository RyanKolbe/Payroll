package com.biconsulting.ryankolbe.controller;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.factory.demographic.GenderFactory;
import com.biconsulting.ryankolbe.factory.demographic.RaceFactory;
import com.biconsulting.ryankolbe.factory.employee.EmployeeFactory;
import com.biconsulting.ryankolbe.factory.employee.EmployeeGenderFactory;
import com.biconsulting.ryankolbe.factory.employee.EmployeeRaceFactory;
import com.biconsulting.ryankolbe.service.demographic.implementation.GenderServiceImp;
import com.biconsulting.ryankolbe.service.demographic.implementation.RaceServiceImp;
import com.biconsulting.ryankolbe.service.employee.implementation.EmployeeGenderServiceImpl;
import com.biconsulting.ryankolbe.service.employee.implementation.EmployeeRaceServiceImpl;
import com.biconsulting.ryankolbe.service.employee.implementation.EmployeeServiceImpl;
import com.biconsulting.ryankolbe.utility.Misc;

public class EmployeeController {
    private EmployeeServiceImpl employeeService = EmployeeServiceImpl.getEmployeeService();
    private EmployeeGenderServiceImpl employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
    private EmployeeRaceServiceImpl employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();
    private GenderServiceImp genderService = GenderServiceImp.getGenderService();
    private RaceServiceImp raceService = RaceServiceImp.getRaceService();
    private Gender gender = null;
    private Race race = null;
    private Employee employee = null;

    public Employee createEmployee(String firstName, String lastName, String genderDesc, String raceDesc) {
        Employee employee = EmployeeFactory.createEmployee(Misc.generateId(), firstName, lastName);
        Race race = RaceFactory.createRace(Misc.generateId(), raceDesc);
        Gender gender = GenderFactory.createGender(Misc.generateId(), genderDesc);
        employeeService.create(employee);
        employeeGenderService.create(EmployeeGenderFactory.
                createEmployeeGender(employee.getEmpNumber(), employee.getEmpFirstName(), employee.getEmpLastName(),
                        gender.getGenderId(), gender.getGenderDescr()));
        employeeRaceService.create(EmployeeRaceFactory.createEmployeeRace(employee.getEmpNumber(),
                employee.getEmpFirstName(), employee.getEmpLastName(), race.getRaceId(), race.getRaceDesc()));

        return employee;
    }
}