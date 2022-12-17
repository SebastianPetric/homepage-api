package com.sebastian.homepage.api.domain.core.academic;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IAcademicService {

    Academic save(Academic experience);

    List<Academic> findAll();

    Optional<Academic> findById(ObjectId id);

    Academic editById(Academic experience, PutBodyAcademic toModify);

    void deleteById(ObjectId id);
}
