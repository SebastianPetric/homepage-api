package com.sebastian.homepage.api.domain.core.academic;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAcademicRepository extends MongoRepository<Academic, ObjectId> {
}
