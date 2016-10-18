package com.itechart.pkr.dao.impl;

import com.itechart.pkr.dao.BaseDAO;
import com.itechart.pkr.domain.Address;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by nipo on 11/26/15.
 */
public class AddressDao implements BaseDAO<Address> {
    //private static Logger log = Logger.getLogger(AddressDao.class.getName());
    private static final Logger log = Logger.getLogger(Address.class);

    private static AddressDao thisDao = null;

    private AddressDao() throws SQLException{

    }

    public static synchronized AddressDao getDao()throws SQLException {

            if (thisDao == null) {
                thisDao = new AddressDao();
            }

        return thisDao;
    }

    public Address load(int id, Connection connection) throws SQLException {
        String SQL_SELECT_ADDRESSES_BY_ID = "SELECT * FROM `iTechArt`.Addresses where id = ?;";
        Address address = null;
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_ADDRESSES_BY_ID)) {
            address = new Address();

            pStatement.setInt(1, id);
            ResultSet resultSet = pStatement.executeQuery();
            resultSet.next();
            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setHouse(resultSet.getString("house"));
            address.setFlat(resultSet.getInt("flat"));
            address.setIndex(resultSet.getString("zipcode"));

            resultSet.close();
        }
        return address;
    }

    @Override
    public Address persist(Address address, Connection connection, int contactId) throws SQLException {
        return address; //пустой метод для соблюдения правил имплементирования
    }

    public Address persist(Address address, Connection connection) throws SQLException {
        int addressId;
        String SQL_INSERT_ADDRESS = "INSERT INTO `iTechArt`.Addresses(country, city, street, house, flat, zipcode) VALUES(?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS)) {

            pStatement.setString(1, address.getCountry());
            pStatement.setString(2, address.getCity());
            pStatement.setString(3, address.getStreet());
            pStatement.setString(4, address.getHouse());
            pStatement.setInt(5, address.getFlat());
            pStatement.setString(6, address.getIndex());
            pStatement.executeUpdate();

            ResultSet resultSet = pStatement.getGeneratedKeys();
            resultSet.next();
            addressId = resultSet.getInt(1);
            address.setId(addressId);

            resultSet.close();
            //генерация ключей возможно не нужна будет с текущими планами на дао
        }
        return address;
    }

    public void update(Address address, Connection connection) throws SQLException {
        String SQL_UPDATE_ADDRESS = "UPDATE `iTechArt`.Addresses SET country = ?, city = ?, street = ?, house = ?, flat = ?, zipcode = ? WHERE id = ?;";

        try (PreparedStatement pStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS)) {

            pStatement.setString(1, address.getCountry());
            pStatement.setString(2, address.getCity());
            pStatement.setString(3, address.getStreet());
            pStatement.setString(4, address.getHouse());
            pStatement.setInt(5, address.getFlat());
            pStatement.setString(6, address.getIndex());
            pStatement.setInt(7, address.getId());
            pStatement.executeUpdate();

        }

    }

    public void delete(Address address, Connection connection) throws SQLException {
        String SQL_DELETE_ADDRESS = "DELETE FROM `iTechArt`.Addresses WHERE id = ?;";
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_DELETE_ADDRESS)) {
            pStatement.setInt(1, address.getId());
            pStatement.executeUpdate();

        }
    }

}
