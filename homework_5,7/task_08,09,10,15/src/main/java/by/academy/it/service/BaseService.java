package by.academy.it.service;

import by.academy.it.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T save(T entity);

    List<T> findAll();

    T findById(String id);

    void update(T entity);

    void delete(String id);
}
