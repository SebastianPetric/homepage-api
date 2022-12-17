package com.sebastian.homepage.api.domain.core.experience;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {

    Experience save(Experience experience);

    List<Experience> findAll();

    Optional<Experience> findById(ObjectId id);

    Experience editById(Experience experience, PutBodyExperience toModify);

    void deleteById(ObjectId id);

}
