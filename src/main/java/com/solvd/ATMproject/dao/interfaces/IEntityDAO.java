package com.solvd.ATMproject.dao.interfaces;

public interface IEntityDAO<T> {
    void create();

    void update();

    T getById(int id);

    void delete(T entity);
}
