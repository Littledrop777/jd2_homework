package by.academy.it.service;

import by.academy.it.dao.Dao;
import by.academy.it.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService implements BaseService<Person> {

    private static final String PERSON_NULL_MSG = "Person can not be null";
    private static final String ID_NULL_MSG = "Id can not be null";
    private Dao<String, Person> personDao;

    @Autowired
    public PersonService(Dao<String, Person> personDaoImpl) {
        this.personDao = personDaoImpl;
    }

    @Transactional
    @Override
    public Person save(Person person) {
        if (person == null) {
            throw new EntityExistsException(PERSON_NULL_MSG);
        }
        return personDao.save(person);
    }

    @Transactional
    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Transactional
    @Override
    public Person findById(String id) {
        if (id == null) {
            throw new EntityExistsException(ID_NULL_MSG);
        }
        return personDao.findById(id);
    }

    @Transactional
    @Override
    public void update(Person person) {
        if (person == null) {
            throw new EntityExistsException(PERSON_NULL_MSG);
        }
        personDao.update(person);
    }

    @Transactional
    @Override
    public void delete(String id) {
        if (id == null) {
            throw new EntityExistsException(ID_NULL_MSG);
        }
        personDao.delete(id);
    }
}
