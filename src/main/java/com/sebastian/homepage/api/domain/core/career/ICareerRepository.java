package com.sebastian.homepage.api.domain.core.career;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICareerRepository extends GenericRepository<Career, PutBodyCareer> {
}
