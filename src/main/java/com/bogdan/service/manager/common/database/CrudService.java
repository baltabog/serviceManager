package com.bogdan.service.manager.common.database;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class CrudService<K extends Model, L extends CrudRepository<K, Long>> {

    protected abstract L getRepository();

    public K getById(long id) {
        return getRepository().findById(id).orElseThrow();
    }

    public List<K> getAll() {
        return StreamSupport.stream(getRepository().findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public K create(K entity) {
        if (entity.getId() != 0) {
            throw new DuplicateKeyException("Unexpected field {id} found!");
        }

        return getRepository().save(entity);
    }

    @Transactional
    public K update(K entity)  {
        if (entity.getId() == 0) {
            throw new NoSuchElementException();
        }

        return getRepository().save(entity);
    }

    @Transactional
    public boolean delete(long id) {
        Optional<K> entity = getRepository().findById(id);
        if (entity.isPresent()) {
            getRepository().delete(entity.get());
            return true;
        }

        return false;
    }
}
