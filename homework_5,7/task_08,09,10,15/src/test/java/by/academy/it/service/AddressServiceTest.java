package by.academy.it.service;

import by.academy.it.config.DaoConfiguration;
import by.academy.it.entity.Address;
import by.academy.it.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Commit
public class AddressServiceTest {

    @Autowired
    private BaseService<Address> addressService;

    @Test
    public void save() {
        Person person = new Person("Alice", 28);
        Address address = new Address("Gomel", "Sovetskaya");
        person.setAddress(address);
        address.setPerson(person);
        addressService.save(address);
        assertNotNull(address.getId());
        addressService.delete(address.getId());
    }

    @Test
    public void update() {
        Person person = new Person("Vladislav", 34);
        Address address = new Address("Gomel", "Sovetskaya");
        address.setPerson(person);
        Address savedAddress = addressService.save(address);
        savedAddress.setCity("Brest");
        addressService.update(savedAddress);
        assertEquals("Brest", savedAddress.getCity());
        assertEquals("Sovetskaya", savedAddress.getStreet());
        addressService.delete(savedAddress.getId());
    }
}