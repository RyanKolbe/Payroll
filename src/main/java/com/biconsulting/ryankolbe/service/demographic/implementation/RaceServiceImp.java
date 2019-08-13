package com.biconsulting.ryankolbe.service.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.repository.demographic.RaceRepository;
import com.biconsulting.ryankolbe.repository.demographic.implementation.RaceRepositoryImp;
import com.biconsulting.ryankolbe.service.demographic.RaceService;

import java.util.Set;

public class RaceServiceImp implements RaceService {
    private static RaceServiceImp raceService = null;
    private RaceRepository raceRepository;

    private RaceServiceImp() {
        this.raceRepository = RaceRepositoryImp.getRaceRepository();
    }

    public static RaceServiceImp getRaceService() {
        if (raceService == null) raceService = RaceServiceImp.getRaceService();
        return raceService;
    }

    @Override
    public Set<Race> getAll() {
        return raceRepository.getAll();
    }

    @Override
    public Race create(Race race) {
        return raceRepository.create(race);
    }

    @Override
    public Race read(String raceId) {
        return raceRepository.read(raceId);
    }

    @Override
    public Race update(Race race) {
        return raceRepository.update(race);
    }

    @Override
    public void delete(String raceId) {
        raceRepository.delete(raceId);
    }
}