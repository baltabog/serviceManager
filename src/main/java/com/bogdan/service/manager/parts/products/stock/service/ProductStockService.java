package com.bogdan.service.manager.parts.products.stock.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import com.bogdan.service.manager.parts.products.stock.repository.ProductStockRepository;
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
        return getRepository().findByContainer(productContainer.getId());
    }

    public List<ProductStock> getForDefinition(ProductDefinition productDefinition) {
        return getRepository().findByDefinition(productDefinition.getId());
    }
}
