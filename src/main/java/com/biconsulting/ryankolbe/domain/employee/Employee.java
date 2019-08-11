package com.biconsulting.ryankolbe.domain.employee;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String empNumber;
    private String empFirstName;
    private String empLastName;

    private Employee() {
    }

    public Employee(Builder builder) {
        this.empNumber = builder.empNumber;
        this.empFirstName = builder.empFirstName;
        this.empLastName = builder.empLastName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNumber='" + empNumber + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmpNumber().equals(employee.getEmpNumber()) &&
                getEmpFirstName().equals(employee.getEmpFirstName()) &&
                getEmpLastName().equals(employee.getEmpLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpNumber(), getEmpFirstName(), getEmpLastName());
    }

    @Override
    public int compareTo(Employee employee) {
        return this.empNumber.compareToIgnoreCase(employee.empNumber);
    }

    public static class Builder {
        private String empNumber;
        private String empFirstName;
        private String empLastName;

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

        public Builder copy(Employee employee) {
            this.empNumber = employee.empNumber;
            this.empFirstName = employee.empFirstName;
            this.empLastName = employee.empLastName;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
