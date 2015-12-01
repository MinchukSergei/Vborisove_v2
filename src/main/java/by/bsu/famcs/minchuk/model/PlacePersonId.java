package by.bsu.famcs.minchuk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlacePersonId implements Serializable {
    @Column(name = "FK_PERSON_ID", nullable = false)
    private String username;

    @Column(name = "FK_PLACE_ID", nullable = false)
    private long placeId;

    public PlacePersonId() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public PlacePersonId(String username, long placeId) {
        this.username = username;
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacePersonId that = (PlacePersonId) o;

        if (placeId != that.placeId) return false;
        return username.equals(that.username);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + (int) (placeId ^ (placeId >>> 32));
        return result;
    }
}