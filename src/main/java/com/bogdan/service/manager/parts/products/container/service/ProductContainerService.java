package com.bogdan.service.manager.parts.products.container.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.container.repository.ProductContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductContainerService extends CrudService<ProductContainer, ProductContainerRepository> {
    private final ProductContainerRepository productDefinitionRepository;

    @Override
    protected ProductContainerRepository getRepository() {
        return productDefinitionRepository;
    }
}
