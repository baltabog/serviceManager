package com.bogdan.service.manager.parts.products.stock.repository;

import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductStockRepository extends CrudRepository<ProductStock, Long> {
    @Query( "SELECT ps " +
            "FROM ProductStock ps " +
            "WHERE ps.containerType.definition.id = :definitionId ")
    List<ProductStock> findByDefinition(long definitionId);

    @Query( "SELECT ps " +
            "FROM ProductStock ps " +
            "WHERE ps.containerType.id = :containerId " +
            " AND ps.containersNo-COALESCE(ps.alreadySelled, 0) > 0 ")
    List<ProductStock> findByContainer(long containerId);
}
