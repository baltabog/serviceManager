package com.bogdan.service.manager.parts.invoice.web;

import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.invoice.service.InvoiceService;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import com.bogdan.service.manager.parts.stock.model.InvoiceStock;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VariableResolver(CoreVariableResolver.class)
public class OutcomeInvoiceManager {
    @WireVariable
    private InvoiceService invoiceService;
    @Getter
    @Setter
    private Invoice selectedInvoice;
    @Getter
    private boolean editDisabled = true;
    @Getter
    private boolean nirDisabled = true;

    public List<Invoice> getInvoices() {
        return invoiceService.getOutcomeInvoice();
    }

    @Command
    public void onSelectInvoice() {
        editDisabled = true;
        nirDisabled = true;
    }

    public boolean isInvoiceUnselected() {
        return selectedInvoice == null;
    }

    public boolean isDownloadDisabled() {
        return selectedInvoice==null || StringUtils.isBlank(selectedInvoice.getDigitalCopyPath());
    }

    public List<InvoiceStock> getInvoiceStocks() {
        if (selectedInvoice!=null && selectedInvoice.getInvoiceStock()!=null) {
            return selectedInvoice.getInvoiceStock();
        }

        return Collections.emptyList();
    }

    public Date getSelectedInvoiceDate() {
        return Date.valueOf(selectedInvoice !=null && selectedInvoice.getDate() != null ? selectedInvoice.getDate() : LocalDate.now());
    }

    public String getContainerInfo(ProductContainer container) {
        if ( container==null ) {
            return StringUtils.EMPTY;
        }
        return String.format("%s - %s - %d%s", container.getDefinition().getName(), container.getBrand(), container.getQuantity(),
                container.getDefinition().getMeasurement());
    }

    @Command
    @NotifyChange({"selectedInvoice", "editDisabled"})
    public void addInvoice() {
        selectedInvoice = new Invoice();
        editDisabled = false;
    }

    @Command
    @NotifyChange("invoiceStocks")
    public void addStockToInvoice() {
        if (CollectionUtils.isEmpty(selectedInvoice.getInvoiceStock())) {
            selectedInvoice.setInvoiceStock(new ArrayList<>());
        }

        selectedInvoice.getInvoiceStock().add(new InvoiceStock());
    }

    @Command
    @NotifyChange({"invoices", "selectedInvoice", "invoiceStocks", "invoiceUnselected"})
    public void saveInvoice() {
        if (selectedInvoice != null && selectedInvoice.getId() > 0) {
            invoiceService.update(selectedInvoice);
        } else if (selectedInvoice.getId() == 0) {
            invoiceService.create(selectedInvoice);
        }

        selectedInvoice = null;
        editDisabled = true;
    }
}
