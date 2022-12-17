package com.sebastian.homepage.api.domain.core.generic;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends MongoRepository<T, ObjectId> {
}
