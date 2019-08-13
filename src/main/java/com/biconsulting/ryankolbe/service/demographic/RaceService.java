package com.biconsulting.ryankolbe.service.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
