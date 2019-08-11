package com.biconsulting.ryankolbe.domain.employee;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.factory.demographic.GenderFactory;
import com.biconsulting.ryankolbe.factory.employee.EmployeeFactory;

import java.util.Objects;

public class EmployeeGender implements Comparable<EmployeeGender> {
    private Employee employee;
    private Gender gender;

    private EmployeeGender() {
    }

    public EmployeeGender(Builder builder) {
        employee = EmployeeFactory.createEmployee(builder.empNumber, builder.empFirstName, builder.empLastName);
        gender = GenderFactory.createGender(builder.genderId, builder.genderDesc);
    }

    public String getEmpNumber() {
        return employee.getEmpNumber();
    }

    public String getEmpFirstName() {
        return employee.getEmpFirstName();
    }

    public String getEmpLastName() {
        return employee.getEmpLastName();
    }

    public String getGenderId() {
        return gender.getGenderId();
    }

    public String getGenderDesc() {
        return gender.getGenderDescr();
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employee=" + employee +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeGender)) return false;
        EmployeeGender that = (EmployeeGender) o;
        return employee.equals(that.employee) &&
                gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, gender);
    }

    @Override
    public int compareTo(EmployeeGender employeeGender) {
        return this.employee.getEmpNumber().compareToIgnoreCase(employeeGender.employee.getEmpNumber());
    }

    public static class Builder {
        private String empNumber;
        private String empFirstName;
        private String empLastName;
        private String genderId;
        private String genderDesc;

        public Builder empNumber(String empNumber) {
            this.empNumber = empNumber;
            return this;
        }

        public Builder empFirstName(String empFirstName) {
            this.empFirstName = empFirstName;
            return this;
        }

        public Builder empLastName(String empLastName) {
            this.empLastName = empLastName;
            return this;
        }

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderDesc(String genderDesc) {
            this.genderDesc = genderDesc;
            return this;
        }

        public Builder copy(EmployeeGender employeeGender) {
            this.empNumber = employeeGender.getEmpNumber();
            this.empFirstName = employeeGender.getEmpFirstName();
            this.empLastName = employeeGender.getEmpLastName();
            this.genderId = employeeGender.getGenderId();
            this.genderDesc = employeeGender.getGenderDesc();
            return this;
        }

        public EmployeeGender build() {
            return new EmployeeGender(this);
        }
    }
}