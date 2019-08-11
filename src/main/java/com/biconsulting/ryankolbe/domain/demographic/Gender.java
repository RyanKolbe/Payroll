package com.biconsulting.ryankolbe.domain.demographic;

import java.util.Objects;

public class Gender implements Comparable<Gender> {
    private String genderId;
    private String genderDescr;

    private Gender() {
    }

    public Gender(Builder builder) {
        this.genderId = builder.genderId;
        this.genderDescr = builder.genderDesc;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDescr() {
        return genderDescr;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderDescr='" + genderDescr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        Gender gender = (Gender) o;
        return getGenderId().equals(gender.getGenderId()) &&
                getGenderDescr().equals(gender.getGenderDescr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGenderId(), getGenderDescr());
    }

    @Override
    public int compareTo(Gender gender) {
        return this.genderDescr.compareToIgnoreCase(gender.genderDescr);
    }

    public static class Builder {
        private String genderId;
        private String genderDesc;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderDesc(String genderDesc) {
            this.genderDesc = genderDesc;
            return this;
        }

        public Builder copy(Gender gender) {
            this.genderId = gender.genderId;
            this.genderDesc = gender.genderDescr;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}