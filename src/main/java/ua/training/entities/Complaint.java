package ua.training.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_complaint")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private User user;

    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "completion_time")
    private Timestamp completionTime;

    @Version
    @Column(name = "VERSION")
    private int version;



}
