package by.bsu.famcs.minchuk.dao;

import by.bsu.famcs.minchuk.model.Person;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Person createPerson(Person person) {
        getCurrentSession().save(person);
        getCurrentSession().flush();
        return person;
    }

    public void updatePerson(Person person) {
        getCurrentSession().update(person);
    }

    public Person getPersonByUsername(String username) {
        return (Person) getCurrentSession().get(Person.class, username);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
