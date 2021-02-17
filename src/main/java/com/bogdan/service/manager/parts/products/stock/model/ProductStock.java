package com.bogdan.service.manager.parts.products.stock.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.products.container.model.ProductContainer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "already_selled")
    private Integer alreadySelled;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Company provider;

    @ManyToOne
    @JoinColumn(name = "in_invoice_id", referencedColumnName = "id")
    private Invoice incomingInvoice;

    private Boolean internalUsage;

    private Double buyingPrice;
    private Integer vat;
    private Double sellingPrice;
    private Integer discount;
    private Double actualSellingPrice;

    private Boolean readyForSell;

    // add more general info
}
