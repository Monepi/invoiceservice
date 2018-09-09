package za.co.digitalplatoon.invoiceservice.invoice.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM user INNER JOIN address on user.id = address.user_id inner join contact on contact.user_id = user.id", nativeQuery = true)
    public List<User> getUsers();

}
