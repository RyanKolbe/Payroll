package com.biconsulting.ryankolbe.repository.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.factory.demographic.RaceFactory;
import com.biconsulting.ryankolbe.repository.demographic.RaceRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpTest {
    private static RaceRepository raceRepository = RaceRepositoryImp.getRaceRepository();
    private static Set<Race> races = new HashSet<>();
    private static Race race;

    @BeforeClass
    public static void setUp() {
        race = RaceFactory.createRace("0001", "Indian");
        races.add(raceRepository.create(race));
    }

    @Test
    public void getRaceRepository() {
        Assert.assertNotNull(raceRepository);
    }

    @Test
    public void getAll() {
        Set<Race> raceSet = raceRepository.getAll();
        Assert.assertEquals(raceSet.size(), raceRepository.getAll().size());
    }

    @Test
    public void create() {
        Race createRace = RaceFactory.createRace("0003", "Asian");
        races.add(raceRepository.create(createRace));
        Assert.assertEquals(createRace, raceRepository.read(createRace.getRaceId()));
    }

    @Test
    public void read() {
        Race readRace = raceRepository.getAll().iterator().next();
        Assert.assertEquals(readRace.getRaceDesc(), raceRepository.read(readRace.getRaceId()).getRaceDesc());
    }

    @Test
    public void update() {
        String newRace = "Black";
        Race updateRace = new Race.Builder().copy(race).raceDesc(newRace).build();
        races.add(raceRepository.update(updateRace));
        Assert.assertEquals(updateRace, raceRepository.read(updateRace.getRaceId()));
    }

    @Test
    public void delete() {
        Race deleteRace = RaceFactory.createRace("0004", "White");
        races.add(raceRepository.create(deleteRace));
        races.remove(deleteRace);
        raceRepository.delete(deleteRace.getRaceId());
        Assert.assertEquals(races.size(), raceRepository.getAll().size());
        Assert.assertFalse(raceRepository.getAll()
                .iterator()
                .next()
                .getRaceDesc()
                .contains("White"));
    }
}