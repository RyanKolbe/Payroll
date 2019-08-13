package com.biconsulting.ryankolbe.service.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.service.IService;

import java.util.Set;

public interface EmployeeRaceService extends IService<EmployeeRace, String> {
    Set<EmployeeRace> getAll();
}