package com.bogdan.service.manager.parts.products.def.rest;

import com.bogdan.service.manager.common.api.CrudAPI;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.products.def.repository.ProductDefinitionRepository;
import com.bogdan.service.manager.parts.products.def.service.ProductDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/product/definition", produces = "application/json")
@RequiredArgsConstructor
public class ProductDefinitionApi extends CrudAPI<ProductDefinition, ProductDefinitionRepository, ProductDefinitionService> {
    private final ProductDefinitionService productDefinitionService;

    @Override
    protected ProductDefinitionService getService() {
        return productDefinitionService;
    }
}
