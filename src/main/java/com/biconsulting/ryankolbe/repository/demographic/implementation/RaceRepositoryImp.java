package com.biconsulting.ryankolbe.repository.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.repository.demographic.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImp implements RaceRepository {
    private static RaceRepositoryImp raceRepository = null;
    private Set<Race> races;

    private RaceRepositoryImp() {
        this.races = new HashSet<>();
    }

    public static RaceRepositoryImp getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImp();
        return raceRepository;
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race create(Race race) {
        races.add(race);
        return race;
    }

    @Override
    public Race read(String raceId) {
        return search(raceId);
    }

    @Override
    public Race update(Race race) {
        Race raceTemp = search(race.getRaceId());
        if (raceTemp != null) {
            this.races.remove(raceTemp);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String raceId) {
        Race raceDelete = search(raceId);
        if (raceDelete != null) this.races.remove(raceDelete);
    }

    private Race search(final String raceId) {
        for (Race raceSearch : this.races) {
            if (raceSearch.getRaceId().equals(raceId))
                return raceSearch;
        }
        return null;
    }
}
