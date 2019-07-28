package ua.training.services;




import ua.training.entities.Report;

import java.util.List;

public interface ReportService {
    List<Report> findAll();
    Report findById(Long id);
    Report save(Report report);
}