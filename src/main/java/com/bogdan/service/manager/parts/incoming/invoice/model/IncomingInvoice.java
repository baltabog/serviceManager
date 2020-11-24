package com.bogdan.service.manager.parts.incoming.invoice.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class IncomingInvoice extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String serialNumber;
    private Integer from_id;
    private Integer to_id;
    // TODO: add stock
    private Double totalPayment;
    private String digitalCopyPath;
    private LocalDateTime receivedDate;
}
