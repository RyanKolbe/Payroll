package com.biconsulting.ryankolbe.service.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.repository.demographic.GenderRepository;
import com.biconsulting.ryankolbe.repository.demographic.implementation.GenderRepositoryImp;
import com.biconsulting.ryankolbe.service.demographic.GenderService;

import java.util.Set;

public class GenderServiceImp implements GenderService {
    private static GenderServiceImp genderService = null;
    private GenderRepository genderRepository;

    private GenderServiceImp() {
        this.genderRepository = GenderRepositoryImp.getGenderRepository();
    }

    public static GenderServiceImp getGenderService() {
        if (genderService == null) genderService = new GenderServiceImp();
        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return genderRepository.create(gender);
    }

    @Override
    public Gender read(String genderId) {
        return genderRepository.read(genderId);
    }

    @Override
    public Gender update(Gender gender) {
        return genderRepository.update(gender);
    }

    @Override
    public void delete(String genderId) {
        genderRepository.delete(genderId);
    }

    @Override
    public Set<Gender> getAll() {
        return genderRepository.getAll();
    }
}
