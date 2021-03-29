package com.bogdan.service.manager.parts.stock.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import com.bogdan.service.manager.parts.stock.model.ProductStock;
import com.bogdan.service.manager.parts.stock.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStockService extends CrudService<ProductStock, ProductStockRepository> {
    private final ProductStockRepository productDefinitionRepository;

    @Override
    protected ProductStockRepository getRepository() {
        return productDefinitionRepository;
    }

    public List<ProductStock> getForContainer(ProductContainer productContainer) {
        return getRepository().findActiveByContainer(productContainer.getId());
    }
}
