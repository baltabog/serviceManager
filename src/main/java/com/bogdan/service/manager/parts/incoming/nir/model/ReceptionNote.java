package com.bogdan.service.manager.parts.incoming.nir.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class ReceptionNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String serialNumber;
    private Integer invoice_id;
    private LocalDateTime receivedDate;
}
