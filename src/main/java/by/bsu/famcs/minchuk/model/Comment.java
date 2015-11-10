package by.bsu.famcs.minchuk.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private long id;

    @Column(name = "COMMENT_SOURCE")
    private String comment_source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PLACE_ID", nullable = false)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_USERNAME", nullable = false)
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment_source() {
        return comment_source;
    }

    public void setComment_source(String comment_source) {
        this.comment_source = comment_source;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
