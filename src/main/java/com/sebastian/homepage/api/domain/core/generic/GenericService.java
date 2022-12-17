package com.sebastian.homepage.api.domain.core.generic;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    protected GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }


    public T save(T entity) {
        return repository.save(entity);
    }


    public List<T> findAll() {
        return repository.findAll();
    }


    public Optional<T> findById(ObjectId id) {
        return repository.findById(id);
    }


    public void deleteById(ObjectId id) {
        repository.deleteById(id);
    }
}
