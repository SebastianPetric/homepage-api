package com.sebastian.homepage.api.domain.core.generic;

import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;

    protected GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository) {
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


    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

}
