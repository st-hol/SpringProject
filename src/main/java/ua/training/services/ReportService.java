package ua.training.services;


import ua.training.entities.Report;
import ua.training.entities.User;

import java.util.List;

public interface ReportService {
    List<Report> findAll();

    List<Report> findAllByPerson(User user);

    Report findById(Long id);

    Report save(Report report);

    void update(long id, Report changed);

}