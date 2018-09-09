package za.co.digitalplatoon.invoiceservice.invoice.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_id_number")
    private String userIdNumber;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Contact.class)
    private Set<Contact> contact;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Address.class)
    private Set<Address> address;

}
