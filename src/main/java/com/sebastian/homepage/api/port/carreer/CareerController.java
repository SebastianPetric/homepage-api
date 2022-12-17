package com.sebastian.homepage.api.port.carreer;

import com.sebastian.homepage.api.domain.core.career.Career;
import com.sebastian.homepage.api.domain.core.career.CareerServiceImpl;
import com.sebastian.homepage.api.domain.core.career.PutBodyCareer;
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
@RequestMapping(value = "/career", produces = MediaType.APPLICATION_JSON_VALUE)
public class CareerController {

    @Autowired
    CareerServiceImpl careerServiceImpl;

    @GetMapping
    public ResponseEntity<List<Career>> getAll() {
        return ResponseEntity.ok(careerServiceImpl.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<Career> career = careerServiceImpl.findById(id);

        if (career.isEmpty())
            throw new NotFoundException(id);

        careerServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<Career> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyCareer toModify) {

        Optional<Career> career = careerServiceImpl.findById(id);

        if (career.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(careerServiceImpl.editById(career.get(), toModify));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid Career career) {
        return ResponseEntity.ok(careerServiceImpl.save(career));
    }
}
