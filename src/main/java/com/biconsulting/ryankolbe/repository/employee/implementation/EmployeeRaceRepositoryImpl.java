package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.repository.employee.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {
    private static EmployeeRaceRepositoryImpl employeeRaceRepository = null;
    private Set<EmployeeRace> employeeRaces;

    private EmployeeRaceRepositoryImpl() {
        employeeRaces = new HashSet<>();
    }

    public static EmployeeRaceRepositoryImpl getEmployeeRaceRepository() {
        if (employeeRaceRepository == null) employeeRaceRepository = new EmployeeRaceRepositoryImpl();
        return employeeRaceRepository;
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return this.employeeRaces;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        employeeRaces.add(employeeRace);
        return employeeRace;
    }

    @Override
    public EmployeeRace read(String employeeRaceId) {
        return search(employeeRaceId);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        EmployeeRace employeeRaceTemp = search(employeeRace.getRaceId());
        if (employeeRaceTemp != null) {
            this.employeeRaces.remove(employeeRaceTemp);
            return create(employeeRace);
        }
        return null;
    }

    @Override
    public void delete(String employeeRaceId) {
        EmployeeRace deleteEmployeeRace = search(employeeRaceId);
        if (employeeRaceId != null) this.employeeRaces.remove(deleteEmployeeRace);

    }

    private EmployeeRace search(final String employeeRaceId) {
        for (EmployeeRace employeeRaceSearch : this.employeeRaces) {
            if (employeeRaceSearch.getEmpNumber().equals(employeeRaceId))
                return employeeRaceSearch;
        }
        return null;
    }
}