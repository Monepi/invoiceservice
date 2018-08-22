package za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers.dto.InvoiceRequestDTO;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers.dto.InvoiceResponseDTO;
import za.co.digitalplatoon.invoiceservice.invoice.srvc.services.InvoiceI;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class InvoiceController {

    private final InvoiceI invoiceI;

    public InvoiceController(InvoiceI invoiceI) {
        this.invoiceI = invoiceI;
    }

    @PostMapping(value = "/invoices", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<InvoiceResponseDTO> addInvoice(@Valid @RequestBody InvoiceRequestDTO invoiceRequestDTO) {

        LineItem lineItem = new LineItem();
        lineItem.setDescription(invoiceRequestDTO.getLineItemRequest().getDescription());
        lineItem.setQuantity(invoiceRequestDTO.getLineItemRequest().getQuantity());
        lineItem.setUnitPrice(invoiceRequestDTO.getLineItemRequest().getUnitPrice());

        Set<LineItem> lineItemSet = new HashSet<>();
        lineItemSet.add(lineItem);

        Invoice invoice = new Invoice();
        invoice.setClient(invoiceRequestDTO.getInvoiceRequest().getClient());
        invoice.setVatRate(invoiceRequestDTO.getInvoiceRequest().getVatRate());
        invoice.setLineItem(lineItemSet);

        invoiceI.createInvoice(invoice);

        InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();
        invoiceResponseDTO.setResponseMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/invoices", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Invoice>> getInvoices() {
        List<Invoice> invoices = this.invoiceI.getInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping(value = "/invoices/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        if (this.invoiceI.getInvoice(id).isPresent()) {
            return new ResponseEntity<>(this.invoiceI.getInvoice(id).get(), HttpStatus.OK);
        }
        return null;
    }

}
