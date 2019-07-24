package ua.training.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "persons")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_person")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.ORDINAL) //todo change indexation
    private ROLE role;

    //this field in table is a reference on itself
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="id_inspector")
    private User assignedInspector;

    //mb fetch = FetchType.LAZY
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Complaint> complaints = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "persons_has_taxable_items",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    private Set<TaxableItem> taxableItems = new HashSet<>();

    @Version
    @Column(name = "version")
    private int version;

    public enum ROLE {
        INSPECTOR, CLIENT, UNKNOWN;

    }
}