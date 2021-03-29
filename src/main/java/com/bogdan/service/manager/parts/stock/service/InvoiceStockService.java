package com.bogdan.service.manager.parts.stock.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.stock.model.InvoiceStock;
import com.bogdan.service.manager.parts.stock.repository.InvoiceStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceStockService extends CrudService<InvoiceStock, InvoiceStockRepository> {
    private final InvoiceStockRepository invoiceStockRepository;

    @Override
    protected InvoiceStockRepository getRepository() {
        return invoiceStockRepository;
    }

    public List<InvoiceStock> getForContainer(Invoice invoice) {
        return getRepository().findByInvoice(invoice.getId());
    }
}
