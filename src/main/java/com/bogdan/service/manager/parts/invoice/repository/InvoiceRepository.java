package com.bogdan.service.manager.parts.invoice.repository;

import com.bogdan.service.manager.parts.invoice.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    // no custom queries
}
