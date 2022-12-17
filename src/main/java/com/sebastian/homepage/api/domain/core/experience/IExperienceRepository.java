package com.sebastian.homepage.api.domain.core.experience;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IExperienceRepository extends MongoRepository<Experience, ObjectId> {
}
