package by.bsu.famcs.minchuk.dao;

import by.bsu.famcs.minchuk.model.Person;

import java.util.List;

/**
 * Created by minchuk on 24/10/15.
 */
public interface PersonDAO {

    public void addPerson(Person person);

    public void removePerson(long id);

}
