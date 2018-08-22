package za.co.digitalplatoon.invoiceservice.invoice.srvc.services;

import za.co.digitalplatoon.invoiceservice.invoice.model.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceI {
    void createInvoice(Invoice invoice);
    List<Invoice> getInvoices();
    Optional<Invoice> getInvoice(Long id);
}
