package com.bogdan.service.manager.parts.products.container.repository;

import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import org.springframework.data.repository.CrudRepository;

public interface ProductContainerRepository extends CrudRepository<ProductContainer, Long> {
    // no custom queries
}
