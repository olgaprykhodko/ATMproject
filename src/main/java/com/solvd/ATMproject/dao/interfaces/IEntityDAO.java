package com.solvd.ATMproject.dao.interfaces;

public interface IEntityDAO<T, P> {
    void create(T entity);

    void update(T entity);

    void add(T entity);

    T getById(int id);

    void delete(T entity);

    T read(P p);
}
