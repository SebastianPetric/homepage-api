package com.sebastian.homepage.api.domain.core.career;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICareerRepository extends MongoRepository<Career, ObjectId> {
}
