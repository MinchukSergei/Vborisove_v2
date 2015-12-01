package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;

import java.util.List;


public interface PlaceService {

    void updatePlace(Place place);

    List<Place> getAllPlaces();

    List<Place> getPlacesOfThePerson(String username);

    void deletePlaceById(long id);

    Place createNewPlace(Place place);

    Place getPlaceById(long id);

    boolean isLiked(Person person, long photoId);

    void setLike(Person person, long photoId);

    void removeLike(Person person, long photoId);
}
