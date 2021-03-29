package com.bogdan.service.manager.parts.invoice.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.stock.model.InvoiceStock;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Invoice implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String serialNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_id")
    private Company senderCompany;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_id")
    private Company receiverCompany;

    @OneToMany(mappedBy = "incomingInvoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InvoiceStock> invoiceStock;

    private Double totalPayment;

    private LocalDate date;

    private String digitalCopyPath;
}
