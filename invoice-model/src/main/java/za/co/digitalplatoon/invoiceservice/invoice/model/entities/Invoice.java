package za.co.digitalplatoon.invoiceservice.invoice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String client;

    @Column
    private Long vatRate;

    @Column
    private LocalDateTime invoiceDate;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<LineItem> lineItem;
}
