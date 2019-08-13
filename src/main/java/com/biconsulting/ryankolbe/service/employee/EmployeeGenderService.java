package com.biconsulting.ryankolbe.service.employee;

import com.biconsulting.ryankolbe.domain.employee.EmployeeGender;
import com.biconsulting.ryankolbe.service.IService;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
}
