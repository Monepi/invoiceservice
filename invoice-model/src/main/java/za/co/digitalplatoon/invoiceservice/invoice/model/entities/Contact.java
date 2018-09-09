package za.co.digitalplatoon.invoiceservice.invoice.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
@ToString
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "land_line_number")
    private String landLineNumber;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Set<User> userId;
}