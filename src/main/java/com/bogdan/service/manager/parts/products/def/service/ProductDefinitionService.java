package com.bogdan.service.manager.parts.products.def.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.products.def.repository.ProductDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDefinitionService extends CrudService<ProductDefinition, ProductDefinitionRepository> {
    private final ProductDefinitionRepository productDefinitionRepository;

    @Override
    protected ProductDefinitionRepository getRepository() {
        return productDefinitionRepository;
    }
}
