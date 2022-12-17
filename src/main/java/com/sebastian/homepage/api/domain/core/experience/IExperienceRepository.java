package com.sebastian.homepage.api.domain.core.experience;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends GenericRepository<Experience, PutBodyExperience> {
}
