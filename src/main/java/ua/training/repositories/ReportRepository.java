package ua.training.repositories;

import ua.training.entities.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.training.entities.Role;
import ua.training.entities.User;

import java.util.List;


@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

    List<Report> findAllByPerson(User user);
}
