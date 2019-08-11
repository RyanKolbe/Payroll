package com.biconsulting.ryankolbe.factory.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import org.junit.Assert;
import org.junit.Test;

public class RaceFactoryTest {

    @Test
    public void createRace() {
        Race race = RaceFactory.createRace("0001","Indian");
        Assert.assertEquals("Indian",race.getRaceDesc());
    }
}