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

import java.util.List;

@VariableResolver(CoreVariableResolver.class)
@Log4j2
public class ProductManagerVM {

    @WireVariable
    private ProductDefinitionService productDefinitionService;
    @WireVariable
    private ProductContainerService productContainerService;
    @WireVariable
    private ProductStockService productStockService;

    @Getter
    @Setter
    private ProductDefinition productDefinition;
    @Getter
    @Setter
    private ProductContainer productContainer;
    @Getter
    @Setter
    private ProductStock productStock;

    public List<ProductDefinition> getProdDefinitions() {
        return productDefinitionService.getAll();
    }

    @Command
    @NotifyChange({"prodContainers", "prodStocks"})
    public void onSelectDefinition() {
        // filter containers by selected definition
    }

    @Command
    public void addDefinition () {
        // TODO implement me
        log.info("Add definition");
    }

    @Command
    public void onEditDefinition(@BindingParam("definition") ProductDefinition productDefinition) {
        // TODO implement me
        log.info("Edit: " + productDefinition);
    }

    @Command
    @NotifyChange("prodDefinitions")
    public void onDeleteDefinition(@BindingParam("definition") ProductDefinition productDefinition) {
        productDefinitionService.delete(productDefinition.getId());
    }

    public List<ProductContainer> getProdContainers() {
        if (productDefinition != null) {
            return productContainerService.getForDefinition(productDefinition);
        }

        return productContainerService.getAll();
    }

    public String getContainerLabel(@BindingParam("container") ProductContainer productContainer) {
        return String.format("%s %s - %d%s", productContainer.getDefinition().getName(), productContainer.getBrand(), productContainer.getQuantity(), productContainer.getDefinition().getMeasurement());
    }

    @Command
    @NotifyChange("prodStocks")
    public void onSelectContainer() {
        // filter containers by selected definition
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

        if (productDefinition != null) {
            return productStockService.getForDefinition(productDefinition);
        }

        return productStockService.getAll();
    }

    public String getStockLabel(@BindingParam("stock") ProductStock productStock) {
        String containerLabel = getContainerLabel(productStock.getContainerType());

        int containerNo = productStock.getContainersNo().intValue();
        int alreadySelled = productStock.getAlreadySelled() != null ? productStock.getAlreadySelled().intValue() : 0;
        if ( Boolean.TRUE.equals(productStock.getReadyForSell()) && (containerNo - alreadySelled > 0) ) {
            return String.format("%s - %dbuc - %sRON", containerLabel, containerNo - alreadySelled, productStock.getActualSellingPrice().toString());
        }

        return String.format("%s - NA", containerLabel);
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

    @Command
    public void onEditStock(@BindingParam("Stock") ProductStock productStock) {
        // TODO implement me
        log.info("Edit: " + productStock);
    }

    @Command
    @NotifyChange("prodStocks")
    public void onDeleteStock(@BindingParam("container") ProductStock productStock) {
        productStockService.delete(productStock.getId());
    }

}
