package com.bogdan.service.manager.parts.product.def.repository;

import com.bogdan.service.manager.parts.product.def.model.ProductDefinition;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductDefinitionRepository extends CrudRepository<ProductDefinition, Long> {

    Optional<ProductDefinition> findByName(String name);
}
