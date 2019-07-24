package ua.training.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.training.entities.Report;

public interface ReportRepository extends CrudRepository<Report, Long> {
}
