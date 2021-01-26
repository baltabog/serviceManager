package com.bogdan.service.manager.parts.products.web;

import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.container.service.ProductContainerService;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.products.def.service.ProductDefinitionService;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import com.bogdan.service.manager.parts.products.stock.service.ProductStockService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Collections;
import java.util.List;

@VariableResolver(CoreVariableResolver.class)
@Log4j2
public class ProductManagerVM {

    @WireVariable
    private ProductContainerService productContainerService;
    @WireVariable
    private ProductStockService productStockService;

    @Getter
    @Setter
    private ProductContainer productContainer;
    @Getter
    @Setter
    private ProductStock productStock;


    public List<ProductContainer> getProdContainers() {
        return productContainerService.getAll();
    }

    public String getContainerContainer(@BindingParam("container") ProductContainer productContainer) {
        return String.format("%d%s", productContainer.getQuantity(), productContainer.getDefinition().getMeasurement());
    }

    @Command
    @NotifyChange("prodStocks")
    public void onSelectContainer() {
        // do nothing
    }

    @Command
    public void addContainer () {
        // TODO implement me
        log.info("Add container");
    }

    @Command
    public void onEditContainer(@BindingParam("container") ProductContainer productContainer) {
        // TODO implement me
        log.info("Edit: " + productContainer);
    }

    @Command
    @NotifyChange("prodContainers")
    public void onDeleteContainer(@BindingParam("container") ProductContainer productContainer) {
        productContainerService.delete(productContainer.getId());
    }

    public List<ProductStock> getProdStocks() {
        if (productContainer != null) {
            return productStockService.getForContainer(productContainer);
        }

        return Collections.emptyList();
    }

    public String getStockLabel(@BindingParam("stock") ProductStock productStock) {
        int containerNo = productStock.getContainersNo().intValue();
        int alreadySelled = productStock.getAlreadySelled() != null ? productStock.getAlreadySelled().intValue() : 0;
        if ( Boolean.TRUE.equals(productStock.getReadyForSell()) && (containerNo - alreadySelled > 0) ) {
            return String.format("%dbuc - %sRON", containerNo - alreadySelled, productStock.getActualSellingPrice().toString());
        }

        return "NA";
    }

    @Command
    public void addStock () {
        // TODO implement me
        log.info("Add stock");
    }

    @Command
    public void onSelectStock() {
        // filter containers by selected definition
    }


}
