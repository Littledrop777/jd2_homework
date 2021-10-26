package by.academy.it.service;

import by.academy.it.dao.ReceiverDao;
import by.academy.it.exception.UnknownEntityException;
import by.academy.it.model.Receiver;

import java.util.List;

public class ReceiverServiceImpl implements ReceiverService {

    private static final String NULL_EXPENSE_MSG = "Receiver can not be null";
    private static ReceiverServiceImpl instance;
    private final ReceiverDao receiverDao;

    private ReceiverServiceImpl() {
        receiverDao = ReceiverDao.retrieve();
    }

    public static ReceiverServiceImpl getInstance() {
        if (instance == null) {
            instance = new ReceiverServiceImpl();
        }
        return instance;
    }

    @Override
    public Receiver save(Receiver receiver) {
        if (receiver == null) {
            throw new UnknownEntityException(NULL_EXPENSE_MSG);
        }
        return receiverDao.save(receiver);
    }

    @Override
    public List<Receiver> findAll() {
        return receiverDao.findAll();
    }
}