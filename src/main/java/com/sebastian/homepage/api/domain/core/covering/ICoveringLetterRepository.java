package com.sebastian.homepage.api.domain.core.covering;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoveringLetterRepository extends GenericRepository<CoveringLetter, PutBodyCoveringLetter> {
}
