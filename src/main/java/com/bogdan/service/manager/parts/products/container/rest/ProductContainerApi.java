package com.bogdan.service.manager.parts.products.container.rest;

import com.bogdan.service.manager.common.api.CrudAPI;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.container.repository.ProductContainerRepository;
import com.bogdan.service.manager.parts.products.container.service.ProductContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/product/container", produces = "application/json")
@RequiredArgsConstructor
public class ProductContainerApi extends CrudAPI<ProductContainer, ProductContainerRepository, ProductContainerService> {
    private final ProductContainerService productDefinitionService;

    @Override
    protected ProductContainerService getService() {
        return productDefinitionService;
    }
}
