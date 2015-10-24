package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.dao.PersonDAO;
import by.bsu.famcs.minchuk.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by minchuk on 24/10/15.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    public void removePerson(long id) {
        personDAO.removePerson(id);
    }
}
