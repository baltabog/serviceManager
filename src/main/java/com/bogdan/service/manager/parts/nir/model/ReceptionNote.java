package com.bogdan.service.manager.parts.nir.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;


@Entity
@Data
public class ReceptionNote implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serialNumber;
    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;
    private LocalDateTime receivedDate;
}
