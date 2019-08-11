package com.biconsulting.ryankolbe.factory.employee;

import com.biconsulting.ryankolbe.domain.employee.Employee;
import com.biconsulting.ryankolbe.utility.Misc;

public class EmployeeFactory {
    public static Employee createEmployee(String empNumber, String empFirstName, String empLastName) {
        return new Employee.Builder()
                .empNumber(empNumber)
                .empFirstName(empFirstName)
                .empLastName(empLastName)
                .build();
    }
}
