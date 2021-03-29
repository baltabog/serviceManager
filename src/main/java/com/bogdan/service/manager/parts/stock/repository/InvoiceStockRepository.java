package com.bogdan.service.manager.parts.stock.repository;

import com.bogdan.service.manager.parts.stock.model.InvoiceStock;
import com.bogdan.service.manager.parts.stock.model.ProductStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceStockRepository extends CrudRepository<InvoiceStock, Long> {

    @Query( "SELECT ps " +
            "FROM InvoiceStock ps " +
            "WHERE ps.incomingInvoice.id = :invoiceId ")
    List<InvoiceStock> findByInvoice(long invoiceId);
}
