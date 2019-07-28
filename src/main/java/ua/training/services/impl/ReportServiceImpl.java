package ua.training.services.impl;

import com.google.common.collect.Lists;
import ua.training.entities.Report;
import ua.training.repositories.ReportRepository;
import ua.training.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    @Override
    public List<Report> findAll() {
        return Lists.newArrayList(reportRepository.findAll());
    }

    @Override
    public Report findById(Long id) {
        return reportRepository.findById(id).get();
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Autowired
    public void setReportRepository(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

}