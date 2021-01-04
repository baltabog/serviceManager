package com.bogdan.service.manager.parts.products.stock.rest;

import com.bogdan.service.manager.common.api.CrudAPI;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import com.bogdan.service.manager.parts.products.stock.repository.ProductStockRepository;
import com.bogdan.service.manager.parts.products.stock.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/product/stock", produces = "application/json")
@RequiredArgsConstructor
public class ProductStockApi extends CrudAPI<ProductStock, ProductStockRepository, ProductStockService> {
    private final ProductStockService productDefinitionService;

    @Override
    protected ProductStockService getService() {
        return productDefinitionService;
    }
}
