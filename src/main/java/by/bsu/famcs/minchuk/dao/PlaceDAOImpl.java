package by.bsu.famcs.minchuk.dao;


import by.bsu.famcs.minchuk.model.Like;
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import by.bsu.famcs.minchuk.model.PlacePersonId;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.beans.Expression;
import java.util.List;

@Repository
public class PlaceDAOImpl implements PlaceDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Place createPlace(Place newPlace) {
        getCurrentSession().save(newPlace);
        getCurrentSession().flush();
        return newPlace;
    }

    @Override
    public void updatePlace(Place place) {
        getCurrentSession().update(place);
        getCurrentSession().flush();
    }

    @SuppressWarnings("unchecked")
    public List<Place> placesList() {
        Criteria criteria = getCurrentSession().createCriteria(Place.class);
        criteria.setFetchMode("person", FetchMode.JOIN);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Place> placesOfThePerson(String username) {
        Criteria criteria = getCurrentSession().createCriteria(Place.class);
        criteria.setFetchMode("person", FetchMode.JOIN);
        criteria.add(Restrictions.eq("person.username", username));
        return criteria.list();
    }

    @Override
    public void deletePlace(long id) {
        Place place = (Place) getCurrentSession().createCriteria(Place.class).
                add(Restrictions.eq("id", id)).list().get(0);
        getCurrentSession().delete(place);
        getCurrentSession().flush();
    }

    @Override
    public Place getPlaceById(long id) {
        Criteria criteria =  getCurrentSession().createCriteria(Place.class).
                add(Restrictions.eq("id", id));
        return (Place)criteria.list().get(0);
    }

    @Override
    public boolean isLiked(Person person, long photoId) {
        Criteria criteria = getCurrentSession().createCriteria(Like.class);
        // criteria.add(Restrictions.eq("likeId", new PlacePersonId(person.getUsername(), photoId)));
        criteria.add(Restrictions.eq("likeId.username", person.getUsername())).add(Restrictions.eq("likeId.placeId", photoId));
        return criteria.list().size() != 0;
    }

    @Override
    public void removeLike(Person person, long photoId) {
        Like like = (Like) getCurrentSession().createCriteria(Like.class).
                add(Restrictions.eq("likeId", new PlacePersonId(person.getUsername(), photoId))).uniqueResult();
        getCurrentSession().delete(like);
        getCurrentSession().flush();
    }

    @Override
    public void setLike(Person person, long photoId) {
        getCurrentSession().save(new Like(new PlacePersonId(person.getUsername(), photoId)));
        getCurrentSession().flush();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
