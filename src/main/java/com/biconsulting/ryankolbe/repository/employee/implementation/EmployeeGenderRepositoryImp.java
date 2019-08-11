package com.biconsulting.ryankolbe.repository.employee.implementation;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.repository.employee.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImp implements EmployeeGenderRepository {
    private static EmployeeGenderRepositoryImp employeeGenderRepository = null;
    private Set<EmployeeGender> employeeGenders;

    private EmployeeGenderRepositoryImp() {
        employeeGenders = new HashSet<>();
    }

    public static EmployeeGenderRepositoryImp getEmployeeGenderRepository() {
        if (employeeGenderRepository == null) employeeGenderRepository = new EmployeeGenderRepositoryImp();
        return employeeGenderRepository;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenders;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    @Override
    public EmployeeGender read(String employeeGenderId) {
        return search(employeeGenderId);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        EmployeeGender employeeGenderTemp = search(employeeGender.getEmpNumber());
        if (employeeGenderTemp != null) {
            this.employeeGenders.remove(employeeGenderTemp);
            return create(employeeGender);
        }
        return null;
    }

    @Override
    public void delete(String employeeGenderId) {
        EmployeeGender employeeGenderDelete = search(employeeGenderId);
        if (employeeGenderDelete != null) this.employeeGenders.remove(employeeGenderDelete);
    }

    private EmployeeGender search(final String employeeGenderId) {
        for (EmployeeGender employeeGenderSearch : this.employeeGenders) {
            if (employeeGenderSearch.getEmpNumber().equals(employeeGenderId))
                return employeeGenderSearch;
        }
        return null;
    }
}
