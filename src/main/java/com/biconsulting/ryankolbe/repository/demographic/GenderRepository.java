package com.biconsulting.ryankolbe.repository.demographic;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender> getAll();
}