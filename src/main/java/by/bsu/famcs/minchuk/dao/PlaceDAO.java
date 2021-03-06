package by.bsu.famcs.minchuk.dao;

import by.bsu.famcs.minchuk.model.Comment;
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;

import java.util.List;

public interface PlaceDAO {
    Place createPlace(Place place);

    void updatePlace(Place place);

    List<Place> placesList();

    List<Place> placesOfThePerson(String username);

    void deletePlace(long id);

    Place getPlaceById(long id);

    boolean isLiked(Person person, long photoId);

    void removeLike(Person person, long photoId);

    void setLike(Person person, long photoId);

    Comment addComment(Comment comment);

    void removeComment(long id);

    void updateComment(Comment comment);

    List<Comment> getCommentsByPhotoId(long id);

    List<Place> getTop5Places();
}
