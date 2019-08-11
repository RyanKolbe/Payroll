package com.biconsulting.ryankolbe.domain.employee;

import com.biconsulting.ryankolbe.domain.demographic.Gender;

import java.util.Objects;

public class EmployeeGender implements Comparable<EmployeeGender> {
    private Employee employee;
    private Gender gender;

    private EmployeeGender() {
    }

    public EmployeeGender(Builder builder) {
        this.employee = builder.employee;
        this.gender = builder.gender;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Gender getGender() {
        return gender;
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
        return getEmployee().equals(that.getEmployee()) &&
                getGender().equals(that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getGender());
    }

    @Override
    public int compareTo(EmployeeGender employeeGender) {
        return this.employee.getEmpNumber().compareToIgnoreCase(employeeGender.employee.getEmpNumber());
    }

    public static class Builder {
        private Employee employee;
        private Gender gender;

        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder copy(EmployeeGender employeeGender) {
            this.employee = employeeGender.employee;
            this.gender = employeeGender.gender;
            return this;
        }

        public EmployeeGender build() {
            return new EmployeeGender(this);
        }
    }
}