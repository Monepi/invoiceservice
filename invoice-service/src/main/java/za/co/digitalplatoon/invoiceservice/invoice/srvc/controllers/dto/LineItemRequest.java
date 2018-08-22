package za.co.digitalplatoon.invoiceservice.invoice.srvc.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LineItemRequest {
    @NotNull(message = "Quantity is required")
    private Long quantity;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Unit price is required")
    private BigDecimal unitPrice;
}
