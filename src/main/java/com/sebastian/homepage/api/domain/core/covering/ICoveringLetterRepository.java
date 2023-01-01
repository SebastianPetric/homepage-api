package com.sebastian.homepage.api.domain.core.covering;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoveringLetterRepository extends GenericRepository<CoveringLetter, PutBodyCoveringLetter> {

    Optional<CoveringLetter> findByType(TextType type);
}
