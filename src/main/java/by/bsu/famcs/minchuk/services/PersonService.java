package by.bsu.famcs.minchuk.services;


import by.bsu.famcs.minchuk.model.Person;

public interface PersonService {
    void update(Person person);

    Person readByPersonName(String username);

    Person registerNewUserAccount(Person newPerson) throws NullPointerException;

    Person readByUserName(String userName);
}
