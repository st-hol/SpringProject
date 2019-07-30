package ua.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.entities.Report;
import ua.training.services.ReportService;
import ua.training.services.UserService;

import java.util.List;


@Controller
@RequestMapping(value = "/inspector")
public class InspectorController {

    private final Logger logger = LoggerFactory.getLogger(InspectorController.class);

    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/personal-cabinet")
    public String personalCabinet() {
        return "inspector/inspector-base";
    }



    @GetMapping(value = "/check-report/{id}")
    public String checkReportForm(@PathVariable Long id, Model uiModel) {
        Report report = reportService.findById(id);
        uiModel.addAttribute("report", report);
        return "inspector/check-report";
    }

    @PostMapping(value = "/check-report")
    public String editReport(@RequestParam Long id, Report report) {
        reportService.check(id, report);
        return "redirect:/inspector/show-reports";
    }


    //todo pagination
    @GetMapping(value = "/show-reports")
    public String list(Model uiModel) {
        logger.info("Listing reports");
        List<Report> reports = reportService.findAllReportsOfPersonsByAssignedInspector(userService
                .obtainCurrentPrincipleUser());
        uiModel.addAttribute("reports", reports);
        logger.info("No. of rec.: " + reports.size());
        return "inspector/show-reports";
    }


//    @GetMapping(value = "/set-taxable")
//    public String setTaxableForm(@PathVariable long id, Model uiModel) {
//        return "";
//    }

}
