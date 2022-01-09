package by.academy.it.service;

import by.academy.it.dao.Dao;
import by.academy.it.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService implements BaseService<Address> {

    private static final String ADDRESS_NULL_MSG = "Address can not be null";
    private static final String ID_NULL_MSG = "Id can not be null";
    private Dao<String, Address> addressDao;

    @Autowired
    public AddressService(@Qualifier("addressDaoImpl") Dao<String, Address> addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address save(Address address) {
        if(address == null){
            throw new EntityExistsException(ADDRESS_NULL_MSG);
        }
        return addressDao.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findById(String id) {
        if(id == null){
            throw new EntityExistsException(ID_NULL_MSG);
        }
        return addressDao.findById(id);
    }

    @Override
    public void update(Address address) {
        if(address == null){
            throw new EntityExistsException(ADDRESS_NULL_MSG);
        }
        addressDao.update(address);
    }

    @Override
    public void delete(String id) {
        if(id == null){
            throw new EntityExistsException(ID_NULL_MSG);
        }
        addressDao.delete(id);
    }
}
