package com.biconsulting.ryankolbe.repository.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.repository.IRepository;

import java.util.Set;

public interface EmployeeRaceRepository extends IRepository<EmployeeRace, String> {
    Set<EmployeeRace> getAll();
}
