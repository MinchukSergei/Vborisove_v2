package by.bsu.famcs.minchuk.dao;


import by.bsu.famcs.minchuk.model.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.ArrayList;
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
                add(Restrictions.eq("id", id)).uniqueResult();
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

    @Override
    public Comment addComment(Comment comment) {
        getCurrentSession().save(comment);
        getCurrentSession().flush();
        return comment;
    }

    @Override
    public void removeComment(long id) {
        Comment comment = (Comment) getCurrentSession().createCriteria(Comment.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        getCurrentSession().delete(comment);
        getCurrentSession().flush();
    }

    @Override
    public void updateComment(Comment comment) {
        getCurrentSession().update(comment);
        getCurrentSession().flush();
    }

    @SuppressWarnings("unchecked")
    public List<Comment> getCommentsByPhotoId(long id) {
        Criteria criteria = getCurrentSession().createCriteria(Comment.class);
        criteria.setFetchMode("place", FetchMode.JOIN);
        criteria.setFetchMode("person", FetchMode.JOIN);
        criteria.add(Restrictions.eq("place.id", id));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Place> getTop5Places() {
        String hql = "SELECT PLACE_ID FROM PLACE LEFT " +
                "OUTER JOIN LIKE_PLACE ON PLACE_ID = FK_PLACE_ID GROUP BY PLACE_ID " +
                "ORDER BY COUNT(FK_PERSON_ID) DESC";
        SQLQuery query = getCurrentSession().createSQLQuery(hql);
        query.setMaxResults(5);
        List<Integer> fakePlacesId = query.list();
        List<Long> truePlacesId = new ArrayList<Long>();
        for (Integer a : fakePlacesId) {
            truePlacesId.add((long) a);
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(Place.class)
                .add(Property.forName("id").in(truePlacesId));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }


    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
