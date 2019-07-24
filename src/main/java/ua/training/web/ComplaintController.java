package ua.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.training.entities.Complaint;
import ua.training.services.ComplaintService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/singers")
public class ComplaintController {

    private final Logger logger = LoggerFactory.getLogger(ComplaintController.class);

    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public String list(Model uiModel) {

        logger.info("Listing singers");
        List<Complaint> complaints = complaintService.findAll();
        uiModel.addAttribute("complaints", complaints);
        logger.info("No. of rec.: " + complaints.size());
        return "complaints";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Complaint complaint = complaintService.findById(id);
        uiModel.addAttribute("singer", complaint);
        return "show";
    }


    @GetMapping(value = "/edit/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("complaint", complaintService.findById(id));
        return "update";
    }


    @GetMapping(value = "/new")
    public String createForm(Model uiModel) {
        Complaint complaint = new Complaint();
        uiModel.addAttribute("complaint", complaint);
        return "update";
    }

    @PostMapping
    public String saveSinger(@Valid Complaint complaint) {
        complaintService.save(complaint);
        return "redirect:/complaints/" + complaint.getId();
    }

}