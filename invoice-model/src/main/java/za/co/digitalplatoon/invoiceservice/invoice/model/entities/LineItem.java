package za.co.digitalplatoon.invoiceservice.invoice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LineItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long quantity;

    @Column
    private String description;

    @Column
    private BigDecimal unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
