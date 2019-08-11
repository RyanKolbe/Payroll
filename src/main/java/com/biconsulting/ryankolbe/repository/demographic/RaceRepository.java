package com.biconsulting.ryankolbe.repository.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Race;
import com.biconsulting.ryankolbe.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}