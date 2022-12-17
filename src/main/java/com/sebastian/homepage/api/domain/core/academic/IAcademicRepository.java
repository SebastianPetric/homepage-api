package com.sebastian.homepage.api.domain.core.academic;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcademicRepository extends GenericRepository<Academic, PutBodyAcademic> {
}
