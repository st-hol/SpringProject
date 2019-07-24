package ua.training.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.training.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
