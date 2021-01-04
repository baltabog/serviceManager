package com.bogdan.service.manager.parts.incoming.invoice.repository;

import com.bogdan.service.manager.parts.incoming.invoice.model.IncomingInvoice;
import org.springframework.data.repository.CrudRepository;

public interface IncomingInvoiceRepository extends CrudRepository<IncomingInvoice, Long> {
    // no custom queries
}
