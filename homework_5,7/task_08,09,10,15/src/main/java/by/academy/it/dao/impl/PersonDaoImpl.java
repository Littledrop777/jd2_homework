package by.academy.it.dao.impl;

import by.academy.it.annotation.MyDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

@MyDao
public class PersonDaoImpl extends BaseDao<String, Person> implements PersonDao {

    @Autowired
    public PersonDaoImpl() {
        super(Person.class);
    }

}
