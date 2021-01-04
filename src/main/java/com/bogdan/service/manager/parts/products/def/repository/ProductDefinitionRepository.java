package com.bogdan.service.manager.parts.products.def.repository;

import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import org.springframework.data.repository.CrudRepository;

public interface ProductDefinitionRepository extends CrudRepository<ProductDefinition, Long> {
    // no custom queries
}
