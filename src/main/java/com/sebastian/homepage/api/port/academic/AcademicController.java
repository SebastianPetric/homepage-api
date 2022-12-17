package com.sebastian.homepage.api.port.academic;

import com.sebastian.homepage.api.domain.core.academic.Academic;
import com.sebastian.homepage.api.domain.core.academic.AcademicServiceImpl;
import com.sebastian.homepage.api.domain.core.academic.PutBodyAcademic;
import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
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
@RequestMapping(value = "/academic", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicController {

    @Autowired
    AcademicServiceImpl academicServiceImpl;

    @GetMapping
    public ResponseEntity<List<Academic>> getAll() {
        return ResponseEntity.ok(academicServiceImpl.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<Academic> academic = academicServiceImpl.findById(id);

        if (academic.isEmpty())
            throw new NotFoundException(id);

        academicServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<Academic> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyAcademic toModify) {

        Optional<Academic> academic = academicServiceImpl.findById(id);

        if (academic.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(academicServiceImpl.editById(academic.get(), toModify));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid Academic academic) {
        return ResponseEntity.ok(academicServiceImpl.save(academic));
    }
}
