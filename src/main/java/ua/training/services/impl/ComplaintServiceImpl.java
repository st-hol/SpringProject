package ua.training.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.entities.Complaint;
import ua.training.entities.Report;
import ua.training.repositories.ComplaintRepository;
import ua.training.repositories.ReportRepository;
import ua.training.services.ComplaintService;
import ua.training.services.ReportService;

import java.util.List;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintRepository complaintRepository;

    @Override
    public List<Complaint> findAll() {
        return Lists.newArrayList(complaintRepository.findAll());
    }

    @Override
    public Complaint findById(Long id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public Complaint save(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Autowired
    public void setComplaintRepository(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

}