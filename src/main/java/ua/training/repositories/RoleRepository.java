package ua.training.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.training.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
