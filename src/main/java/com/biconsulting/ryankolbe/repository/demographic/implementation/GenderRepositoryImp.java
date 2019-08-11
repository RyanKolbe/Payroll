package com.biconsulting.ryankolbe.repository.demographic.implementation;

import com.biconsulting.ryankolbe.domain.demographic.Gender;
import com.biconsulting.ryankolbe.repository.demographic.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImp implements GenderRepository {
    private static GenderRepositoryImp genderRepository = null;
    private Set<Gender> genders;

    private GenderRepositoryImp() {
        this.genders = new HashSet<>();
    }

    public static GenderRepositoryImp getGenderRepository() {
        if (genderRepository == null) genderRepository = new GenderRepositoryImp();
        return genderRepository;
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender read(String genderId) {
        return search(genderId);
    }

    @Override
    public Gender update(Gender gender) {
        Gender genderTemp = search(gender.getGenderId());
        if (genderTemp != null) {
            genders.remove(genderTemp);
            return create(gender);
        }
        return null;
    }

    @Override
    public void delete(String genderId) {
        Gender genderDelete = search(genderId);
        if (genderDelete != null) this.genders.remove(genderDelete);

    }

    private Gender search(final String genderId) {
        for (Gender genderSearch : this.genders) {
            if (genderSearch.getGenderId().equals(genderId))
                return genderSearch;
        }
        return null;
    }
}