package com.sebastian.homepage.api.port.academic;

import com.sebastian.homepage.api.domain.core.academic.Academic;
import com.sebastian.homepage.api.domain.core.academic.AcademicServiceImpl;
import com.sebastian.homepage.api.domain.core.academic.PutBodyAcademic;
import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import com.sebastian.homepage.api.domain.core.generic.GenericController;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/academic", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicController extends GenericController<Academic> {

    @Autowired
    AcademicServiceImpl academicServiceImpl;

    protected AcademicController(GenericRepository<Academic> repository) {
        super(repository);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<Academic> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyAcademic toModify) {

        Optional<Academic> academic = academicServiceImpl.findById(id);

        if (academic.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(academicServiceImpl.editById(academic.get(), toModify));
    }
}
