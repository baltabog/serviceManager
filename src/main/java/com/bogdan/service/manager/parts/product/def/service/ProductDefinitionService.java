package com.bogdan.service.manager.parts.product.def.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.product.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.product.def.repository.ProductDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDefinitionService extends CrudService<ProductDefinition, ProductDefinitionRepository> {
    private final ProductDefinitionRepository productDefinitionRepository;

    @Override
    protected ProductDefinitionRepository getRepository() {
        return productDefinitionRepository;
    }

    public ProductDefinition findByNameOrCreate(ProductDefinition suggestedProductDefinition) {
        Optional<ProductDefinition> optionalProductDefinition = getRepository().findByName(suggestedProductDefinition.getName());

        if (optionalProductDefinition.isPresent()) {
            return optionalProductDefinition.get();
        }

        return getRepository().save(suggestedProductDefinition);
    }
}
