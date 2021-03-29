package com.bogdan.service.manager.parts.stock.repository;

import com.bogdan.service.manager.parts.stock.model.ProductStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductStockRepository extends CrudRepository<ProductStock, Long> {

    @Query( "SELECT ps " +
            "FROM ProductStock ps " +
            "WHERE ps.containerType.id = :containerId " +
            " AND ps.containersNo-COALESCE(ps.selledContainers, 0) > 0 ")
    List<ProductStock> findActiveByContainer(long containerId);
}
