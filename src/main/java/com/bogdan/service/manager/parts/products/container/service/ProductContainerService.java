package com.bogdan.service.manager.parts.products.container.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.container.repository.ProductContainerRepository;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductContainerService extends CrudService<ProductContainer, ProductContainerRepository> {
    private final ProductContainerRepository productDefinitionRepository;

    @Override
    protected ProductContainerRepository getRepository() {
        return productDefinitionRepository;
    }

    public List<ProductContainer> getForDefinition(ProductDefinition productDefinition) {
        return getRepository().findByDefinition(productDefinition.getId());
    }
}
