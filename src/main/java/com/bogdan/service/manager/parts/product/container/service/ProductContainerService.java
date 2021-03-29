package com.bogdan.service.manager.parts.product.container.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import com.bogdan.service.manager.parts.product.container.repository.ProductContainerRepository;
import com.bogdan.service.manager.parts.product.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.product.def.service.ProductDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductContainerService extends CrudService<ProductContainer, ProductContainerRepository> {
    private final ProductContainerRepository productContainerRepository;
    private final ProductDefinitionService productDefinitionService;

    @Override
    protected ProductContainerRepository getRepository() {
        return productContainerRepository;
    }

    public ProductContainer createOrUpdate(ProductContainer productContainer) {
        productContainer.setDefinition(getDefinition(productContainer.getDefinition()));
        return getRepository().save(productContainer);
    }

    private ProductDefinition getDefinition(ProductDefinition receivedDefinition) {
        ProductDefinition productDefinition = productDefinitionService.findByNameOrCreate(receivedDefinition);
        if (!productDefinition.getMeasurement().equals(receivedDefinition.getMeasurement())) {
            productDefinition.setMeasurement(receivedDefinition.getMeasurement());
            productDefinitionService.update(productDefinition);
        }

        return productDefinition;
    }
}
