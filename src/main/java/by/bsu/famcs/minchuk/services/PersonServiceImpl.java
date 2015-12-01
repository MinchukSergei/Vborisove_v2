package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.dao.PersonDAO;
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.utils.handlers.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;


@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    public void update(Person person) {
        personDAO.updatePerson(person);
    }

    public Person registerNewUserAccount(Person newPerson) throws NullPointerException {
        if (usernameExist(newPerson.getName())) {
            throw new NullPointerException("User with this username is already exist. Username: " + newPerson.getName());
        }
        Person person = new Person();

        person.setName(newPerson.getName());
        person.setEmail(newPerson.getEmail());
        person.setPassword(customPasswordEncoder.encodePassword(newPerson.getPassword(), newPerson.getUsername()));
        person.setUsername(newPerson.getUsername());
        person = personDAO.createPerson(person);

        return person;
    }

    private boolean usernameExist(final String name) {
        final Person user = personDAO.getPersonByUsername(name);
        return user != null;
    }

    public Person readByUserName(String userName) {
        return personDAO.getPersonByUsername(userName);
    }
}
