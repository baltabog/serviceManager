package com.bogdan.service.manager.parts.products.container.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.common.enums.MeasurementEnum;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class ProductContainer implements Model {
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

    // add more general info
}
