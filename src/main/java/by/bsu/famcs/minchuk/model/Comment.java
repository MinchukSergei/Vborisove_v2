package by.bsu.famcs.minchuk.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PLACE_COMMENT")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private long id;

    @Column(name = "COMMENT_SOURCE", nullable = false)
    private String commentSource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PLACE_ID", nullable = false)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_ID", nullable = false)
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentSource() {
        return commentSource;
    }

    public void setCommentSource(String commentSource) {
        this.commentSource = commentSource;
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
