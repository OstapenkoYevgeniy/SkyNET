package com.gmail.ostapenkoyevgeniy.skynet.dao;

import java.util.List;

public interface Dao<T, K> {
    T insert(T object) throws DaoException;

    int update(T object) throws DaoException;

    int delete(T object) throws DaoException;

    T getByPK(K key) throws DaoException;

    T getByColumn(String column, String value) throws DaoException;

    List<T> getAll() throws DaoException;

}
