package com.solvd.ATMproject.dao.interfaces;

public interface IEntityDAO<T> {
    void create(T entity);

    void update(T entity);

    T getById(long id);

    void delete(T entity);
}
