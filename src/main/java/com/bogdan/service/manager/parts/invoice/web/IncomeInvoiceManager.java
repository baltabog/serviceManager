package com.bogdan.service.manager.parts.invoice.web;

import com.bogdan.service.manager.parts.company.model.Company;
import com.bogdan.service.manager.parts.company.service.CompanyService;
import com.bogdan.service.manager.parts.invoice.model.Invoice;
import com.bogdan.service.manager.parts.invoice.service.InvoiceService;
import com.bogdan.service.manager.parts.product.container.model.ProductContainer;
import com.bogdan.service.manager.parts.product.container.service.ProductContainerService;
import com.bogdan.service.manager.parts.stock.model.InvoiceStock;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.spring.init.CoreVariableResolver;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VariableResolver(CoreVariableResolver.class)
public class IncomeInvoiceManager {
    @WireVariable
    private InvoiceService invoiceService;
    @WireVariable
    private CompanyService companyService;
    @WireVariable
    private ProductContainerService productContainerService;
    @Getter
    @Setter
    private Invoice selectedInvoice;
    @Getter
    private boolean editDisabled = true;

    public List<Invoice> getInvoices() {
        return invoiceService.getIncomeInvoice();
    }

    @Command
    @NotifyChange({"invoiceStocks", "editDisabled", "invoiceUnselected"})
    public void onSelectInvoice() {
        editDisabled = true;
    }

    public List<Company> getSupplierCompanies() {
        return companyService.getSuppliers();
    }

    public boolean isInvoiceUnselected() {
        return selectedInvoice == null;
    }

    public List<InvoiceStock> getInvoiceStocks() {
        if (selectedInvoice!=null && selectedInvoice.getInvoiceStock()!=null) {
            return selectedInvoice.getInvoiceStock();
        }

        return Collections.emptyList();
    }

    public void setSelectedInvoiceDate(Date date) {
        if (selectedInvoice == null) {
            return;
        }

        selectedInvoice.setDate(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

    public Date getSelectedInvoiceDate() {
        return Date.valueOf(selectedInvoice !=null && selectedInvoice.getDate() != null ? selectedInvoice.getDate() : LocalDate.now());
    }

    public List<ProductContainer> getContainers() {
        return productContainerService.getAll();
    }

    public String getContainerInfo(ProductContainer container) {
        if ( container==null ) {
            return StringUtils.EMPTY;
        }
        return String.format("%s - %s - %d%s", container.getDefinition().getName(), container.getBrand(), container.getQuantity(),
                container.getDefinition().getMeasurement());
    }

    @Command
    @NotifyChange({"selectedInvoice", "editDisabled", "invoiceStocks"})
    public void addInvoice() {
        selectedInvoice = new Invoice();
        selectedInvoice.setReceiverCompany(companyService.getOwner().orElse(null));
        selectedInvoice.setDate(LocalDate.now());
        editDisabled = false;
    }

    @Command
    @NotifyChange("invoiceStocks")
    public void addStockToInvoice() {
        if(selectedInvoice == null) {
            return;
        }

        if (CollectionUtils.isEmpty(selectedInvoice.getInvoiceStock())) {
            selectedInvoice.setInvoiceStock(new ArrayList<>());
        }

        selectedInvoice.getInvoiceStock().add(new InvoiceStock());
    }

    @Command
    @NotifyChange({"invoices", "selectedInvoice", "invoiceStocks", "editDisabled"})
    public void saveInvoice() {
        calculateTotal();
        selectedInvoice.getInvoiceStock().stream().forEach(is -> is.setIncomingInvoice(selectedInvoice));

        if (selectedInvoice != null && selectedInvoice.getId() > 0) {
            invoiceService.update(selectedInvoice);
        } else if (selectedInvoice.getId() == 0) {
            invoiceService.create(selectedInvoice);
        }

        selectedInvoice = null;
        editDisabled = true;
    }

    @Command
    @NotifyChange({"selectedInvoice"})
    public void calculateTotal() {
        double total = 0;

        if (selectedInvoice!=null && selectedInvoice.getInvoiceStock()!=null) {
            for (InvoiceStock invoiceStock: selectedInvoice.getInvoiceStock()) {
                double price = invoiceStock.getPrice() != null ? invoiceStock.getPrice().doubleValue() : 0;
                double no = invoiceStock.getContainersNo() != null ? invoiceStock.getContainersNo() : 0;
                total += (price * no);
            }
        }

        selectedInvoice.setTotalPayment(total);
    }

    @Command
    @NotifyChange({"editDisabled", "selectedInvoice", "invoiceStocks"})
    public void onEditInvoice(@BindingParam("invoice") Invoice invoiceStock) {
        selectedInvoice = invoiceStock;
        editDisabled = false;
    }
}
