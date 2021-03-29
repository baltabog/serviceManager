package com.bogdan.service.manager.parts.stock.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class InvoiceStock implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "container_id")
    private ProductContainer containerType;

    @Column(name = "qty")
    private Integer containersNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "in_invoice_id", nullable = false)
    private Invoice incomingInvoice;

    @Column
    private Double price;

    @Column
    private Integer discount;

    @Column
    private Double actualPrice;
}
