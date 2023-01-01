package com.sebastian.homepage.api.domain.core.covering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoveringLetterService {

    @Autowired
    ICoveringLetterRepository repository;

    public Optional<CoveringLetter> findByType(TextType type) {
        return repository.findByType(type);
    }
}
