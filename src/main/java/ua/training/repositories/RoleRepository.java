package ua.training.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.training.entities.Role;
import ua.training.entities.User;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    //List<Role> findAllByIdPerson();
    //List<Role> findByPersons_userName(String userName);
    List<Role> findAllByUsers(User user);

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
}
