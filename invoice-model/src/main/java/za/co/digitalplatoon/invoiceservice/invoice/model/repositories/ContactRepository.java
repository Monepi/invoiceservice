package za.co.digitalplatoon.invoiceservice.invoice.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
