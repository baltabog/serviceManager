package com.bogdan.service.manager.parts.products.stock.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import com.bogdan.service.manager.parts.products.stock.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductStockService extends CrudService<ProductStock, ProductStockRepository> {
    private final ProductStockRepository productDefinitionRepository;

    @Override
    protected ProductStockRepository getRepository() {
        return productDefinitionRepository;
    }
}
