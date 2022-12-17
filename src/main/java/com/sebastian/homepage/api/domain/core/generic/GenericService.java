package com.sebastian.homepage.api.domain.core.generic;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T extends GenericEntity<T, B>, B extends GenericPutBody<B>> {

    private final GenericRepository<T, B> repository;

    protected GenericService(GenericRepository<T, B> repository) {
        this.repository = repository;
    }


    public T save(T entity) {
        return repository.save(entity);
    }


    public List<T> findAll() {
        return repository.findAll();
    }

    public T editById(T entity, B toModify) {
        T updated = entity.editOriginal(toModify);
        return repository.save(updated);
    }

    public Optional<T> findById(ObjectId id) {
        return repository.findById(id);
    }


    public void deleteById(ObjectId id) {
        repository.deleteById(id);
    }
}
