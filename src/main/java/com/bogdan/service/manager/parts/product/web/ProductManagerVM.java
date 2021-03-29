package com.bogdan.service.manager.parts.product.web;

import com.bogdan.service.manager.common.enums.MeasurementEnum;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import com.bogdan.service.manager.parts.product.container.service.ProductContainerService;
import com.bogdan.service.manager.parts.product.def.model.ProductDefinition;
import com.bogdan.service.manager.parts.stock.model.ProductStock;
import com.bogdan.service.manager.parts.stock.service.ProductStockService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Arrays;
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
    private boolean editDisabled = true;

    public List<ProductContainer> getProdContainers() {
        return productContainerService.getAll();
    }

    public String getContainerContainer(@BindingParam("container") ProductContainer productContainer) {
        return String.format("%d%s", productContainer.getQuantity(), productContainer.getDefinition().getMeasurement());
    }

    @Command
    @NotifyChange({"prodStocks", "editDisabled"})
    public void onSelectContainer() {
        editDisabled = true;
    }

    @Command
    @NotifyChange({"productContainer", "editDisabled"})
    public void addContainer () {
        productContainer = new ProductContainer();
        productContainer.setDefinition(new ProductDefinition());

        editDisabled = false;
    }

    @Command
    @NotifyChange({"productContainer", "editDisabled"})
    public void onEditContainer(@BindingParam("container") ProductContainer productContainer) {
        this.productContainer = productContainer.getCopy();
        editDisabled = false;
    }

    @Command
    @NotifyChange({"prodContainers", "prodStocks"})
    public void onDeleteContainer(@BindingParam("container") ProductContainer productContainer) {
        productContainerService.delete(productContainer.getId());
    }

    public List<ProductStock> getProdStocks() {
        if (productContainer != null) {
            return productStockService.getForContainer(productContainer);
        }

        return Collections.emptyList();
    }

    public List<MeasurementEnum> getMeasurementTypes() {
        return Arrays.asList(MeasurementEnum.values().clone());
    }

    @Command
    @NotifyChange({"prodContainers", "prodStocks", "editDisabled"})
    public void saveContainer() {
        productContainerService.createOrUpdate(productContainer);
        editDisabled = true;
    }

    public int getStockAvailableQty(@BindingParam("stock") ProductStock productStock) {
        return productStock.getContainersNo().intValue() - (productStock.getSelledContainers() != null ? productStock.getSelledContainers() : 0);
    }

    @Command
    public void onAddToSoppingCart(@BindingParam("stock") ProductStock productStock) {
        log.debug("onAddToSoppingCart -> " + productStock);
    }
}
