package com.bogdan.service.manager.parts.product.container.repository;

import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductContainerRepository extends CrudRepository<ProductContainer, Long> {

    @Query( "SELECT pc " +
            "FROM ProductContainer pc " +
            "WHERE pc.definition.id = :definitionId ")
    List<ProductContainer> findByDefinition(long definitionId);
}
