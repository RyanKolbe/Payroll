package com.biconsulting.ryankolbe.domain.employee;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.factory.demographic.RaceFactory;
import com.biconsulting.ryankolbe.factory.employee.EmployeeFactory;

import java.util.Objects;

public class EmployeeRace implements Comparable<EmployeeRace> {
    private Employee employee;
    private Race race;

    private EmployeeRace() {
    }

    public EmployeeRace(Builder builder) {
        employee = EmployeeFactory.createEmployee(builder.empNumber, builder.empFirstName, builder.empLastName);
        race = RaceFactory.createRace(builder.raceId, builder.raceDesc);
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

    public String getRaceId() {
        return race.getRaceId();
    }

    public String getRaceDesc() {
        return race.getRaceDesc();
    }

    @Override
    public String toString() {
        return "EmployeeRace{" +
                "employee=" + employee +
                ", race=" + race +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRace)) return false;
        EmployeeRace that = (EmployeeRace) o;
        return employee.equals(that.employee) &&
                race.equals(that.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, race);
    }

    @Override
    public int compareTo(EmployeeRace employeeRace) {
        return this.employee.getEmpNumber().compareToIgnoreCase(employeeRace.getEmpNumber());
    }

    public static class Builder {
        private String empNumber;
        private String empFirstName;
        private String empLastName;
        private String raceId;
        private String raceDesc;

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

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceDesc(String raceDesc) {
            this.raceDesc = raceDesc;
            return this;
        }

        public Builder copy(EmployeeRace employeeRace) {
            this.empNumber = employeeRace.getEmpNumber();
            this.empFirstName = employeeRace.getEmpFirstName();
            this.empLastName = employeeRace.getEmpLastName();
            this.raceId = employeeRace.getRaceId();
            this.raceDesc = employeeRace.getRaceDesc();
            return this;
        }

        public EmployeeRace build() {
            return new EmployeeRace(this);
        }
    }
}
