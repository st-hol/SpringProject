package ua.training.entities;


import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "taxable_items")
public class TaxableItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_item")
    private long id;

    @ManyToMany
    @JoinTable(name = "persons_has_taxable_items",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    private Set<User> persons = new HashSet<>();

    @Column(name = "name_item")
    private String name;

    @Column(name = "price")
    private long price;

    @Version
    @Column(name = "VERSION")
    private int version;
}
