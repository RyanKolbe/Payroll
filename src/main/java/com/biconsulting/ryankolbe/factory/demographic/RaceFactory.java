package com.biconsulting.ryankolbe.factory.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Race;

public class RaceFactory {
    public static Race createRace(String raceId, String raceDesc) {
        return new Race.Builder()
                .raceId(raceId)
                .raceDesc(raceDesc)
                .build();
    }
}
