package ua.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.training.entities.Complaint;
import ua.training.entities.Report;
import ua.training.services.ReportService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/inspector")
public class InspectorController {

    private final Logger logger = LoggerFactory.getLogger(InspectorController.class);

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/personal-cabinet")
    public String personalCabinet() {
        return "inspector/inspector-base";
    }



    @GetMapping(value = "/check-report/{id}")
    public String checkReportForm(@PathVariable long id, Model uiModel) {
        Report report = reportService.findById(id);
        uiModel.addAttribute("report", report);
        return "client/edit-report";
    }



    @GetMapping(value = "/set-taxable")
    public String setTaxableForm(@PathVariable long id, Model uiModel) {
        return "";
    }

}
