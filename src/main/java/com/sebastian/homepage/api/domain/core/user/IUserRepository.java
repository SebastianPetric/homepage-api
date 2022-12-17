package com.sebastian.homepage.api.domain.core.user;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends GenericRepository<User, PutBodyUser> {
}
