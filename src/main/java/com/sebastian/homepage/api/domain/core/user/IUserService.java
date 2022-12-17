package com.sebastian.homepage.api.domain.core.user;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(ObjectId id);

    User editById(User user, PutBodyUser toModify);

    void deleteById(ObjectId id);
}
