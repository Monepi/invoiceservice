package za.co.digitalplatoon.invoiceservice.invoice.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "street_name")
    private  String streetName;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "area_code")
    private String areaCode;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Set<User> userId;
}
