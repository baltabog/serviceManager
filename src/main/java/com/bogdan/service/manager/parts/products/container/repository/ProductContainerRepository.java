package com.bogdan.service.manager.parts.products.container.repository;

import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductContainerRepository extends CrudRepository<ProductContainer, Long> {

    @Query( "SELECT pc " +
            "FROM ProductContainer pc " +
            "WHERE pc.definition.id = :definitionId ")
    List<ProductContainer> findByDefinition(long definitionId);
}
