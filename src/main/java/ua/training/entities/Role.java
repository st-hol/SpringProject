package ua.training.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @Column(name = "name_role")
    private String name;

    @ManyToMany
    @JoinTable(name = "persons_has_roles",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    private Set<User> users = new HashSet<>();


}










//    @Transient
//    static Role defaultRoleByRegistrationInstance;
//
//    public static Role getDefaultRoleInstance() {
//        if (defaultRoleByRegistrationInstance == null) {
//            synchronized (Role.class) {
//                if (defaultRoleByRegistrationInstance == null) {
//                    defaultRoleByRegistrationInstance = new Role();
//                    defaultRoleByRegistrationInstance.setId(0L);
//                    defaultRoleByRegistrationInstance.setName("CLIENT");
//                }
//            }
//        }
//        return defaultRoleByRegistrationInstance;
//    }

