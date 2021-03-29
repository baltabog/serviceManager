package com.bogdan.service.manager.parts.invoice.repository;

import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Query("SELECT i " +
            "FROM Invoice i " +
            "WHERE i.senderCompany.type = :type")
    List<Invoice> findBySenderCompanyType(CompanyTypeEnum type);
}
