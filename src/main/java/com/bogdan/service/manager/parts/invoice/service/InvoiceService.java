package com.bogdan.service.manager.parts.invoice.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.common.enums.CompanyTypeEnum;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService extends CrudService<Invoice, InvoiceRepository> {
    private final InvoiceRepository invoiceRepository;

    @Override
    protected InvoiceRepository getRepository() {
        return invoiceRepository;
    }

    public List<Invoice> getIncomeInvoice() {
        return getRepository().findBySenderCompanyType(CompanyTypeEnum.SUPPLIER);
    }

    public List<Invoice> getOutcomeInvoice() {
        return getRepository().findBySenderCompanyType(CompanyTypeEnum.CLIENT);
    }
}
