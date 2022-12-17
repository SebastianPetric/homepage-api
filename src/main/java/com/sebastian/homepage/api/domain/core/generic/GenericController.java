package com.sebastian.homepage.api.domain.core.generic;

import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends GenericEntity<T, B>, B extends GenericPutBody<B>> {

    private final GenericService<T, B> service;

    protected GenericController(GenericRepository<T, B> repository) {
        this.service = new GenericService<>(repository) {
        };
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<T> entity = service.findById(id);

        entity.orElseThrow(() -> new NotFoundException(id));

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<T> editById(@PathVariable ObjectId id, @RequestBody @Valid B toModify) {

        Optional<T> entity = service.findById(id);

        if (entity.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(service.editById(entity.get(), toModify));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

}
