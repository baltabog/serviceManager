package com.bogdan.service.manager.parts.product.container.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.product.def.model.ProductDefinition;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class ProductContainer implements Model, Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne
    @JoinColumn(name = "definition", referencedColumnName = "id")
    private ProductDefinition definition;
    private String brand;
    @NotNull
    private Integer quantity;
    @Column(name = "stock_qty")
    private Integer stockQuantity;

    public ProductContainer getCopy() {
        ProductContainer productContainer = new ProductContainer();
        productContainer.setId(id);
        productContainer.setDefinition(definition);
        productContainer.setBrand(brand);
        productContainer.setQuantity(quantity);
        productContainer.setStockQuantity(stockQuantity);

        return productContainer;
    }
}
