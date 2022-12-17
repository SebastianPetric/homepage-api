package com.sebastian.homepage.api.port.carreer;

import com.sebastian.homepage.api.domain.core.career.Career;
import com.sebastian.homepage.api.domain.core.career.CareerServiceImpl;
import com.sebastian.homepage.api.domain.core.career.PutBodyCareer;
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
@RequestMapping(value = "/career", produces = MediaType.APPLICATION_JSON_VALUE)
public class CareerController extends GenericController<Career> {

    @Autowired
    CareerServiceImpl careerServiceImpl;

    protected CareerController(GenericRepository<Career> repository) {
        super(repository);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<Career> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyCareer toModify) {

        Optional<Career> career = careerServiceImpl.findById(id);

        if (career.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(careerServiceImpl.editById(career.get(), toModify));
    }
}
