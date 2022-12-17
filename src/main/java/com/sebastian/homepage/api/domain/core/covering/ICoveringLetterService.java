package com.sebastian.homepage.api.domain.core.covering;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ICoveringLetterService {

    CoveringLetter save(CoveringLetter experience);

    List<CoveringLetter> findAll();

    Optional<CoveringLetter> findById(ObjectId id);

    CoveringLetter editById(CoveringLetter experience, PutBodyCoveringLetter toModify);

    void deleteById(ObjectId id);
}
