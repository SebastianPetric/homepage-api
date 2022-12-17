package com.sebastian.homepage.api.domain.core.covering;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICoveringLetterRepository extends MongoRepository<CoveringLetter, ObjectId> {
}
