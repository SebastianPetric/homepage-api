package com.sebastian.homepage.api.domain.core.career;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ICareerService {

    Career save(Career experience);

    List<Career> findAll();

    Optional<Career> findById(ObjectId id);

    Career editById(Career experience, PutBodyCareer toModify);

    void deleteById(ObjectId id);
}
