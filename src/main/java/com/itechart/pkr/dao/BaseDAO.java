package com.itechart.pkr.dao;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by nipo on 11/25/15.
 */
public interface BaseDAO<T> {

    T load(int id, Connection connection) throws SQLException;

    T persist(T element, Connection connection, int contactId) throws SQLException;

    void update(T element, Connection connection) throws SQLException;

    void delete(T element, Connection connection) throws SQLException;



}
