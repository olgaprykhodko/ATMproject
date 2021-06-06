package com.solvd.ATMproject.dao.interfaces;

<<<<<<< HEAD
public interface IEntityDAO<T> {
=======
public interface IEntityDAO<T, P> {
>>>>>>> 915ca7cd0734faf34118fb487e885497786f5bb9
    void create(T entity);

    void update(T entity);

    T getById(long id);

    void delete(T entity);

    T read(P p);
}
