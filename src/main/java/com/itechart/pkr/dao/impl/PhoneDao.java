package com.itechart.pkr.dao.impl;

import com.itechart.pkr.dao.BaseDAO;
import com.itechart.pkr.domain.Phone;
import com.itechart.pkr.domain.PhoneType;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Created by nipo on 11/26/15.
 */
public class PhoneDao implements BaseDAO<Phone> {

    //private static final Logger log = Logger.getLogger(PhoneDao.class);

    private static PhoneDao thisDao = null;

    private PhoneDao() throws SQLException{

    }
    public static synchronized PhoneDao getDao()throws SQLException {

            if (thisDao == null) {
                thisDao = new PhoneDao();
            }

        return thisDao;
    }

    public ArrayList<Phone> loadAllPhones(int contactId, Connection connection) throws SQLException, NullPointerException{
        String SQL_SELECT_PHONE_BY_CONTACT_ID = "SELECT * FROM `iTechArt`.Phone WHERE contact_id = ?;";
        ArrayList<Phone> phones = new ArrayList<Phone>();

        try (PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_PHONE_BY_CONTACT_ID)) {
            pStatement.setInt(1, contactId);

            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getInt("id"));
                phone.setCountryCode(resultSet.getString("country_code"));
                phone.setOperatorsCode(resultSet.getString("operators_code"));
                phone.setPhoneNumber(resultSet.getString("phone_number"));
                phone.setType(PhoneType.valueOf(resultSet.getString("phone_type")));
                phone.setComment((resultSet.getString("comment")));

                phones.add(phone);

            }
        }

        return phones; //новый метод для добавления всех телефонов
    }

    public Phone load(int id, Connection connection) throws SQLException{
        String SQL_SELECT_PHONE_BY_ID = "SELECT * FROM `iTechArt`.Phone WHERE id = ?;";
        Phone phone = new Phone();
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_PHONE_BY_ID)) {
            pStatement.setInt(1, id);

            ResultSet resultSet = pStatement.executeQuery();
            resultSet.next();
            phone.setId(resultSet.getInt("id"));
            phone.setCountryCode(resultSet.getString("country_code"));
            phone.setOperatorsCode(resultSet.getString("operators_code"));
            phone.setPhoneNumber(resultSet.getString("phone_number"));
            phone.setType(PhoneType.valueOf(resultSet.getString("phone_type")));
            phone.setComment((resultSet.getString("comment")));

        }

        return phone;
    }

    public Phone persist(Phone phone, Connection connection, int contactId) throws SQLException {
        int phoneId;
        String SQL_INSERT_PHONE = "INSERT INTO `iTechArt`.Phone (country_code, operators_code, phone_number, phone_type, comment, contact_id) VALUES ( ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_PHONE, Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, phone.getCountryCode());
            pStatement.setString(2, phone.getOperatorsCode());
            pStatement.setString(3, phone.getPhoneNumber());
            pStatement.setString(4, valueOf(phone.getType())); //Date.valueOf(valueOf(contact.getDateOfBirth()))
            pStatement.setString(5, phone.getComment());
            pStatement.setInt(6, contactId);
            pStatement.executeUpdate();
            ResultSet resultSet = pStatement.getGeneratedKeys();
            resultSet.next();
            phoneId = resultSet.getInt(1);
            phone.setId(phoneId);


//генерацию ключей возможно убрать
        }
        return phone;
    }


    public void update(Phone phone, Connection connection) throws SQLException {
        String SQL_UPDATE_PHONE = "UPDATE `iTechArt`.Phone SET country_code = ?, operators_code = ?, phone_number = ?, phone_type = ?, comment = ? WHERE id = ?;";

        try (PreparedStatement pStatement = connection.prepareStatement(SQL_UPDATE_PHONE)) {
            pStatement.setString(1, phone.getCountryCode());
            pStatement.setString(2, phone.getOperatorsCode());
            pStatement.setString(3, phone.getPhoneNumber());
            pStatement.setString(4, valueOf(phone.getType())); //Date.valueOf(valueOf(contact.getDateOfBirth()))
            pStatement.setString(5, phone.getComment());
            pStatement.setInt(6, phone.getId());
            pStatement.executeUpdate();
        }

    }

    public void delete(Phone phone, Connection connection) throws SQLException {
        String SQL_DELETE_PHONE = "DELETE FROM `iTechArt`.Phone WHERE id = ?;";
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_DELETE_PHONE)) {

            pStatement.setInt(1, phone.getId());
            pStatement.executeUpdate();


        }
    }
}
