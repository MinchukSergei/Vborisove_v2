package by.bsu.famcs.minchuk.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LIKE_PLACE", uniqueConstraints = @UniqueConstraint(columnNames = {"FK_PLACE_ID", "FK_PERSON_ID"}))
public class Like implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PlacePersonId likeId;

    public Like() {
    }

    public PlacePersonId getLikeId() {
        return likeId;
    }

    public void setLikeId(PlacePersonId likeId) {
        this.likeId = likeId;
    }

    public Like(PlacePersonId likeId) {
        this.likeId = likeId;
    }
}

