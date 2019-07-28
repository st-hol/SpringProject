package ua.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.training.entities.Complaint;
import ua.training.entities.Role;
import ua.training.entities.User;
import ua.training.services.ComplaintService;
import ua.training.services.UserService;

import java.time.Instant;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

@Controller
public class CommonController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cabinet")
    public String personalCabinet(){
        return "cabinet";
    }


    @Autowired
    private UserService userService;

    @Autowired
    private ComplaintService complaintService;


    @GetMapping("/shit")
    public String shit(){

        User user = new User();
        user.setFirstName("11s");
        user.setLastName("s11s");
        user.setEmail("d11sf");
        user.setPassword("12");

        Role role = new Role();
        role.setId(0L);
        role.setName("INSPECTOR");
        user.setRoles(Collections.singleton(role));

        Complaint complaint = new Complaint();
        complaint.setContent("fdsa");
        complaint.setCompletionTime(Calendar.getInstance().getTime());
        User user1 = new User();
        user1.setId(1);
        complaint.setUser(user1);

        complaintService.save(complaint);
        userService.save(user);

        return "redirect:/complaints";
    }

}
