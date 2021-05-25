package com.solvd.financialproject.dao.interfaces;

public interface IEntityDAO<T> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void getById(T entity);
}
