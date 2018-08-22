package za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceRequest {
    @NotNull(message = "Client is required")
    private String client;
    @NotNull(message = "Vat rate is required")
    private Long vatRate;
}
