package za.co.digitalplatoon.invoiceservice.invoice.srvc.services;

import org.springframework.stereotype.Service;
import za.co.digitalplatoon.invoiceservice.invoice.model.entities.User;
import za.co.digitalplatoon.invoiceservice.invoice.model.repositories.UserRepository;

import java.util.List;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
