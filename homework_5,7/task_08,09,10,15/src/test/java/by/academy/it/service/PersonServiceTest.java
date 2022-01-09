package by.academy.it.service;

import by.academy.it.config.DaoConfiguration;
import by.academy.it.entity.Address;
import by.academy.it.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Commit
public class PersonServiceTest {

    @Autowired
    @Qualifier("personService")
    BaseService<Person> personService;

    @Test
    public void saveTest() {
        Person person = new Person("Ivan", 25);
        Address address = new Address("Minsk", "Lenina");
        person.setAddress(address);
        address.setPerson(person);
        Person savedPerson = personService.save(person);
        assertNotNull(savedPerson.getId());
        personService.delete(person.getId());
    }

    @Test
    public void updateTest() {
        Person person = new Person("Maria", 30);
        Person savedPerson = personService.save(person);
        savedPerson.setAge(32);
        savedPerson.setName("Anna");
        personService.update(savedPerson);
        assertEquals(32, savedPerson.getAge());
        assertEquals("Anna", savedPerson.getName());
        personService.delete(savedPerson.getId());
    }
}