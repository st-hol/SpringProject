package ua.training.services;


import ua.training.entities.Report;
import ua.training.entities.User;

import java.util.List;

public interface ReportService {
    List<Report> findAll();
    Report findById(Long id);
    Report save(Report report);
}