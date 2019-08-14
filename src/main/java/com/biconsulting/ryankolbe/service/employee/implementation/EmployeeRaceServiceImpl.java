package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeRace;
import com.biconsulting.ryankolbe.repository.employee.EmployeeRaceRepository;
import com.biconsulting.ryankolbe.repository.employee.implementation.EmployeeRaceRepositoryImpl;
import com.biconsulting.ryankolbe.service.employee.EmployeeRaceService;

import java.util.Set;

public class EmployeeRaceServiceImpl implements EmployeeRaceService {
    private static EmployeeRaceServiceImpl employeeRaceService = null;
    private EmployeeRaceRepository employeeRaceRepository;

    private EmployeeRaceServiceImpl() {
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getEmployeeRaceRepository();
    }

    public static EmployeeRaceServiceImpl getEmployeeRaceService() {
        if (employeeRaceService == null) employeeRaceService = new EmployeeRaceServiceImpl();
        return employeeRaceService;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        return employeeRaceRepository.create(employeeRace);
    }

    @Override
    public EmployeeRace read(String employeeRaceId) {
        return employeeRaceRepository.read(employeeRaceId);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        return employeeRaceRepository.update(employeeRace);
    }

    @Override
    public void delete(String employeeRaceId) {
        employeeRaceRepository.delete(employeeRaceId);
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return employeeRaceRepository.getAll();
    }
}