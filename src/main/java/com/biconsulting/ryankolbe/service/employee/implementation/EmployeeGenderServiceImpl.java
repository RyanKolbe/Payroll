package com.biconsulting.ryankolbe.service.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.repository.employee.EmployeeGenderRepository;
import com.biconsulting.ryankolbe.repository.employee.implementation.EmployeeGenderRepositoryImp;
import com.biconsulting.ryankolbe.service.employee.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {
    private static EmployeeGenderServiceImpl employeeGenderService = null;
    private EmployeeGenderRepository employeeGenderRepository;

    private EmployeeGenderServiceImpl() {
        this.employeeGenderRepository = EmployeeGenderRepositoryImp.getEmployeeGenderRepository();
    }

    public static EmployeeGenderServiceImpl getEmployeeGenderService() {
        if (employeeGenderService == null) employeeGenderService = new EmployeeGenderServiceImpl();
        return employeeGenderService;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return employeeGenderRepository.create(employeeGender);
    }

    @Override
    public EmployeeGender read(String employeeGenderId) {
        return employeeGenderRepository.read(employeeGenderId);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return employeeGenderRepository.update(employeeGender);
    }

    @Override
    public void delete(String employeeGenderId) {
        employeeGenderRepository.delete(employeeGenderId);
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return employeeGenderRepository.getAll();
    }
}
