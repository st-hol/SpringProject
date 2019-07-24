package ua.training.repositories;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.training.entities.Complaint;
import ua.training.entities.Report;
import ua.training.entities.User;
import ua.training.services.UserService;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class ReportRepositoryTest {

    private ReportRepository reportRepository;

    @Autowired
    public void setComplaintRepository(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    @Test
    public void testSave(){
        User user = new User();
        user.setId(1);
        Report report = new Report();
        report.setPerson(user);
        report.setCompletionTime(new Timestamp(System.currentTimeMillis()));
        report.setTaxpayerCode("123");
        report.setTotalAmountOfProperty(123L);

        reportRepository.save(report);

        //get all, list should have 9
        Iterable<Report> reports = reportRepository.findAll();
        int count = 0;

        for(Report s : reports){
            count++;
        }

        assertEquals(count, 9);
    }

}