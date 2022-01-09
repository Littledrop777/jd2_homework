package by.academy.it.dao.impl;

import by.academy.it.annotation.MyDao;
import by.academy.it.dao.AddressDao;
import by.academy.it.entity.Address;


@MyDao
public class AddressDaoImpl extends BaseDao<String, Address> implements AddressDao {

    public AddressDaoImpl() {
        super(Address.class);
    }
}
