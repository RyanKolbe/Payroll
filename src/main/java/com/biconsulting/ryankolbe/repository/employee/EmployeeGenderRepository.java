package com.biconsulting.ryankolbe.repository.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.repository.IRepository;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
}
