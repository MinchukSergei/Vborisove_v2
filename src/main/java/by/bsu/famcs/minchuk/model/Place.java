package by.bsu.famcs.minchuk.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PLACE")
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLACE_ID")
    private long id;

    @Column(name = "PLACE_NAME", nullable = false)
    private String name;

    @Column(name = "PLACE_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PLACE_IMAGE", nullable = false)
    private byte[] imageBytes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_USERNAME", nullable = false)
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
