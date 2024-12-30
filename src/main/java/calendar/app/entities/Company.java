package calendar.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String logoUrl;

    private String location;

    private String linkedInProfile;

    @ElementCollection
    private List<String> emails;

    @ElementCollection
    private List<String> phoneNumbers;

    private String comments;

    private String communicationPeriodicity;

    @ManyToMany
    @JoinTable(
            name = "user_company",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Message> messages;
}