package by.bsu.famcs.minchuk.dao;

import by.bsu.famcs.minchuk.model.Person;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by minchuk on 24/10/15.
 */

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    public void removePerson(long id) {
        Person person = (Person) sessionFactory.getCurrentSession().load(Person.class, id);
        if (person != null) {
            sessionFactory.getCurrentSession().delete(person);
        }
    }

    public Person getUserById (long id) {
        return (Person)sessionFactory.getCurrentSession().get(Person.class, id);
    }
}
