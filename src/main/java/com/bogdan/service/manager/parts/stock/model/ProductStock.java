package com.bogdan.service.manager.parts.stock.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
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

    @Column(name = "containers")
    private Integer containersNo;

    @Column(name = "selled_containers")
    private Integer selledContainers;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Company provider;

    @ManyToOne
    @JoinColumn(name = "in_invoice_id", referencedColumnName = "id")
    private Invoice incomingInvoice;

    @Column
    private Integer vat;

    @Column
    private Double price;
}
