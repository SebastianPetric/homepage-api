package com.sebastian.homepage.api.port.experience;

import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import com.sebastian.homepage.api.domain.core.experience.Experience;
import com.sebastian.homepage.api.domain.core.experience.ExperienceServiceImpl;
import com.sebastian.homepage.api.domain.core.experience.PutBodyExperience;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/experiences", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController {

    @Autowired
    ExperienceServiceImpl experienceServiceImpl;

    @GetMapping
    public ResponseEntity<List<Experience>> getAll() {
        return ResponseEntity.ok(experienceServiceImpl.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<Experience> experience = experienceServiceImpl.findById(id);

        if (experience.isEmpty())
            throw new NotFoundException(id);

        experienceServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<Experience> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyExperience toModify) {

        Optional<Experience> experience = experienceServiceImpl.findById(id);

        if (experience.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(experienceServiceImpl.editById(experience.get(), toModify));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid Experience experience) {
        return ResponseEntity.ok(experienceServiceImpl.save(experience));
    }
}
