package com.bogdan.service.manager.common.database;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class CrudService<K extends Model, L extends CrudRepository<K, Integer>> {

    protected abstract L getRepository();

    public K getById(Integer id) {
        return getRepository().findById(id).orElseThrow();
    }

    public List<K> getAll() {
        return StreamSupport.stream(getRepository().findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public K create(K K) {
        if (K.getId() != null) {
            throw new DuplicateKeyException("Unexpected field {id} found!");
        }

        return getRepository().save(K);
    }

    public K update(K K)  {
        if (K.getId() == null) {
            throw new NoSuchElementException();
        }

        return getRepository().save(K);
    }

    public boolean delete(Integer id) {
        Optional<K> K = getRepository().findById(id);
        if (K.isPresent()) {
            getRepository().delete(K.get());
            return true;
        }

        return false;
    }
}
