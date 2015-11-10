package by.bsu.famcs.minchuk.dao;

import by.bsu.famcs.minchuk.model.Person;

import java.util.List;

public interface PersonDAO {

    Person createPerson(Person person);

    void updatePerson(Person person);

    Person getPersonByUsername(String username);
}
