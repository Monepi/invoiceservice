package za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceRequestDTO {
    private InvoiceRequest invoiceRequest;
    private LineItemRequest lineItemRequest;
}
