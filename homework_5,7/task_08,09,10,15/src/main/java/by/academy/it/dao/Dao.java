package by.academy.it.dao;

import by.academy.it.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface Dao<K extends Serializable, T extends BaseEntity<K>> {

    T save(T entity);

    List<T> findAll();

    T findById(K id);

    void update(T entity);

    void delete(K id);
}
