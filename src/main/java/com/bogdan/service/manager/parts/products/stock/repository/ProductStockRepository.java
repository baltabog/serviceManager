package com.bogdan.service.manager.parts.products.stock.repository;

import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import org.springframework.data.repository.CrudRepository;

public interface ProductStockRepository extends CrudRepository<ProductStock, Long> {
    // no custom queries
}
