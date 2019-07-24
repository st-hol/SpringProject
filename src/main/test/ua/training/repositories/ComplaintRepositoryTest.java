package ua.training.repositories;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.training.entities.Complaint;
import ua.training.entities.User;
import ua.training.services.UserService;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class ComplaintRepositoryTest {

    private ComplaintRepository complaintRepository;

    @Autowired
    public void setComplaintRepository(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }


    @Test
    public void testSave(){

//        Complaint complaint = new Complaint();
//
//        User user = new User();
//        user.setId(1);
//        complaint.setUser(user);
//        complaint.setContent("ADa231232");
//        complaint.setCompletionTime(new Timestamp(System.currentTimeMillis()));
//        complaintRepository.save(complaint);

//        //get all, list should have 5
//        Iterable<Complaint> complaints = complaintRepository.findAll();
//        int count = 0;
//
//        for(Complaint s : complaints){
//            count++;
//        }
//
//        assertEquals(count, 5);
    }

}