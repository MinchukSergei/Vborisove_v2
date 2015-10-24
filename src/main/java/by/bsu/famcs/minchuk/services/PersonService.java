package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.model.Person;

/**
 * Created by minchuk on 24/10/15.
 */
public interface PersonService {
    public void addPerson(Person person);

    public void removePerson(long id);
}
