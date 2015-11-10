package by.bsu.famcs.minchuk.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = {"ROLE", "FK_PERSON_USERNAME"}))
public class UserRole {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private long id;

    @Column(name = "ROLE")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_USERNAME", nullable = false)
    private Person person;

    public UserRole() {

    }

    public UserRole(Person person, String role) {
        this.person = person;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
