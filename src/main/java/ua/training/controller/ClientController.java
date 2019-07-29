package ua.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.entities.Complaint;
import ua.training.entities.Report;
import ua.training.entities.Role;
import ua.training.entities.User;
import ua.training.services.ComplaintService;
import ua.training.services.ReportService;
import ua.training.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/client")
public class ClientController {


    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ComplaintService complaintService;
    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/personal-cabinet")
    public String personalCabinet() {
        return "client/client-base";
    }

    @GetMapping(value = "/make-complaint")
    public String createComplaintForm(Model uiModel) {
        Complaint complaint = new Complaint();
        uiModel.addAttribute("complaint", complaint);
        return "client/make-complaint";
    }

    @GetMapping(value = "/make-report")
    public String createReportForm(Model uiModel) {

        Report report = new Report();
        uiModel.addAttribute("report", report);
        return "client/make-report";
    }

    @PostMapping(value = "/make-report")
    public String saveReport(@ModelAttribute("report") Report report, Principal principal) {
        User loggedInUser = userService.findByUsername(principal.getName());
        report.setPerson(loggedInUser);
        report.setCompletionTime(Calendar.getInstance().getTime());
        reportService.save(report);
        return "client/make-report";
    }



    @GetMapping(value = "/edit-report/{id}")
    public String editReportForm(@PathVariable long id, Model uiModel) {
        Report report = reportService.findById(id);
        uiModel.addAttribute("report", report);
        return "client/edit-report";
    }


    @PostMapping(value = "/make-complaint")
    public String saveComplaint(@Valid Complaint complaint) {
        complaintService.save(complaint);
        return "redirect:/client/personal-cabinet";
    }


    //todo pagination
    @GetMapping(value = "/show-reports")
    public String list(Model uiModel) {
        logger.info("Listing reports");
        List<Report> reports = reportService.findAll();
        uiModel.addAttribute("reports", reports);
        logger.info("No. of rec.: " + reports.size());
        return "client/show-reports";
    }
}
