package com.biconsulting.ryankolbe.service.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.factory.demographic.RaceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class RaceServiceImpTest {
    private static RaceServiceImp raceService = RaceServiceImp.getRaceService();
    private static Race race;

    @BeforeClass
    public static void setUp() {
        race = RaceFactory.createRace("0001", "Indian");
        raceService.create(race);
    }

    @Test
    public void getRaceService() {
        Assert.assertNotNull(raceService);
    }

    @Test
    public void create() {
        Race createRace = raceService.create(RaceFactory.createRace("0002", "Asian"));
        Assert.assertEquals(createRace, raceService.read(createRace.getRaceId()));
    }

    @Test
    public void read() {
        Race readRace = raceService.read(retrieve().getRaceId());
        Assert.assertEquals(readRace, raceService.read(readRace.getRaceId()));
    }

    @Test
    public void update() {
        String newRace = "German";
        Race updateRace = new Race.Builder().copy(race).raceDesc(newRace).build();
        raceService.update(updateRace);
        Assert.assertEquals(newRace, raceService.read(updateRace.getRaceId()).getRaceDesc());
    }

    @Test
    public void delete() {
        Race deleteRace = raceService.create(
                RaceFactory.createRace("0003", "White"));
        raceService.delete(deleteRace.getRaceId());
        Assert.assertFalse(raceService.getAll()
                .iterator()
                .next()
                .getRaceDesc()
                .contains("White"));
    }

    @Test
    public void getAll() {
        Set<Race> raceSet = raceService.getAll();
        Assert.assertEquals(raceSet, raceService.getAll());
    }

    private Race retrieve() {
        return raceService.getAll().iterator().next();
    }
}
