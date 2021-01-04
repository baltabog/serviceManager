package com.bogdan.service.manager.parts.products.stock.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.common.enums.MeasurementEnum;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.incoming.invoice.model.IncomingInvoice;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import com.bogdan.service.manager.parts.products.def.model.ProductDefinition;
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
public class ProductStock implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne
    @JoinColumn(name = "container_id", referencedColumnName = "id")
    private ProductContainer containerType;
    @Column(name = "qty")
    private Integer containersNo;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Company provider;

    @OneToOne
    @JoinColumn(name = "in_invoice_id", referencedColumnName = "id")
    private IncomingInvoice incomingInvoice;

    private Boolean internalUsage;

    private Double buyingPrice;
    private Integer vat;
    private Double sellingPrice;
    private Integer discount;
    private Double actualSellingPrice;

    private boolean readyForSell;

    // add more general info
}
