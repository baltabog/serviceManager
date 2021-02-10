package com.bogdan.service.manager.parts.incoming.invoice.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
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
public class IncomingInvoice implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serialNumber;
    @OneToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id")
    private Company senderCompany;
    @OneToOne
    @JoinColumn(name = "to_id", referencedColumnName = "id")
    private Company receiverCompany;
    private Double totalPayment;
    private LocalDateTime receivedDate;
    private String digitalCopyPath;
}
