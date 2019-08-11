package com.biconsulting.ryankolbe.domain.demographic;

import java.util.Objects;

public class Race implements Comparable<Race> {
    private String raceId;
    private String raceDesc;

    private Race() {
    }

    public Race(Builder builder) {
        this.raceId = builder.raceId;
        this.raceDesc = builder.raceDesc;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceDesc() {
        return raceDesc;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceDesc='" + raceDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return getRaceId().equals(race.getRaceId()) &&
                getRaceDesc().equals(race.getRaceDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRaceId(), getRaceDesc());
    }

    @Override
    public int compareTo(Race race) {
        return this.raceDesc.compareToIgnoreCase(race.raceDesc);
    }

    public static class Builder {
        private String raceId;
        private String raceDesc;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceDesc(String raceDesc) {
            this.raceDesc = raceDesc;
            return this;
        }

        public Builder copy(Race race) {
            this.raceId = race.raceId;
            this.raceDesc = race.raceDesc;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }
}