package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.dao.PlaceDAO;
import by.bsu.famcs.minchuk.model.Comment;
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

    @Override
    public void updatePlace(Place place) {
        placeDAO.updatePlace(place);
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeDAO.placesList();
    }

    @Override
    public List<Place> getPlacesOfThePerson(String username) {
        return placeDAO.placesOfThePerson(username);
    }

    @Override
    public void deletePlaceById(long id) {
        placeDAO.deletePlace(id);
    }

    @Override
    public Place createNewPlace(Place place) {
        placeDAO.createPlace(place);
        return place;
    }

    @Override
    public Place getPlaceById(long id) {
        return placeDAO.getPlaceById(id);
    }

    @Override
    public boolean isLiked(Person person, long photoId) {
        return placeDAO.isLiked(person, photoId);
    }

    @Override
    public void setLike(Person person, long photoId) {
        placeDAO.setLike(person, photoId);
    }

    @Override
    public void removeLike(Person person, long photoId) {
        placeDAO.removeLike(person, photoId);
    }

    @Override
    public Comment addComment(Comment comment) {
        placeDAO.addComment(comment);
        return comment;
    }

    @Override
    public void removeComment(long id) {
        placeDAO.removeComment(id);
    }

    @Override
    public void updateComment(Comment comment) {
        placeDAO.updateComment(comment);
    }

    @Override
    public List<Comment> getCommentsByPlaceId(long id) {
        return placeDAO.getCommentsByPhotoId(id);
    }

    @Override
    public List<Place> getTop5Places() {
        return placeDAO.getTop5Places();
    }
}
