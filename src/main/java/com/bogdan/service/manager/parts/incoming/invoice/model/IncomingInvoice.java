package com.bogdan.service.manager.parts.incoming.invoice.model;

import com.bogdan.service.manager.common.database.Model;
import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.products.stock.model.ProductStock;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;


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
