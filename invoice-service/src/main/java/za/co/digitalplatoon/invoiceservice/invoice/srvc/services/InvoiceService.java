package za.co.digitalplatoon.invoiceservice.invoice.srvc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.model.repositories.InvoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService implements InvoiceI {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void createInvoice(Invoice invoice) {
        this.invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getInvoices() {
        return (List<Invoice>) this.invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getInvoice(Long id) {
        return Optional.ofNullable(this.invoiceRepository.findOne(id));
    }
}
