package com.bogdan.service.manager.common.api;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.common.database.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class CrudAPI <K extends Model, L extends CrudRepository<K, Long>, M extends CrudService<K, L>> {
    protected abstract M getService();

    @GetMapping("/{id}")
    public K getById(@PathVariable Integer id) {
        return getService().getById(id);
    }

    @GetMapping("/all")
    public List<K> getAll() {
        return getService().getAll();
    }

    @PostMapping
    public K create(@RequestBody K entity) {
        return getService().create(entity);
    }

    @PutMapping
    public K update(@RequestBody K entity) {
        return getService().update(entity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return getService().delete(id);
    }
}
