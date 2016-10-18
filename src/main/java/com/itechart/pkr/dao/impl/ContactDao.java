package com.itechart.pkr.dao.impl;

import com.itechart.pkr.dao.BaseDAO;
import com.itechart.pkr.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
//в методе persist использовать методы других дао ? мб использовать метод load и в него параметром кидать
//возможно стоит добавить метод loadById в другие дао и использовать его для вставки в preparedStatement в load() ContactDao

public class ContactDao implements BaseDAO<Contact> {
    private static final String SQL_SELECT_CONTACTS_BY_ID = "SELECT * FROM `iTechArt`.Contacts ORDER BY id";

    private static final String SQL_SELECT_CONTACT_BY_ID = "SELECT * FROM `iTechArt`.Contacts WHERE id = ?";

    private static final String SQL_INSERT_CONTACT = "INSERT INTO `iTechArt`.CONTACTS (first_name, last_name," +
            " patronymic, date_of_birth, gender, nationality, marital_status, web_site, email, current_job," +
            " photo_id, address_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_CONTACT = "UPDATE `iTechArt`.CONTACTS SET first_name = ?, last_name = ?," +
            " patronymic = ?, date_of_birth = ?, gender = ?, nationality = ?, marital_status = ?, web_site = ?," +
            " email = ?, current_job = ?, photo_id = ?, address_id = ? WHERE id = ?";

    private static final String SQL_DELETE_CONTACT = "DELETE FROM `iTechArt`.CONTACTS WHERE id = ?";

    private static final String SQL_SEARCH_CONTACTS_BY_NAME = "SELECT * FROM `iTechArt`.Contacts where first_name like ?" +
            " or last_name like ? or patronymic like ? ORDER BY id";


    private int numOfRecords;

    public int getNumOfRecords() {
        return numOfRecords;
    }

    private static volatile ContactDao thisDao;

    public static ContactDao getDao() throws SQLException {
        if (thisDao == null) {
            synchronized (ContactDao.class) {
                if (thisDao == null) {
                    thisDao = new ContactDao();
                }
            }
        }
        return thisDao;
    }

    public List<Contact> loadAllContacts(Connection connection) throws SQLException {
        final List<Contact> contacts = new ArrayList<>();
        try ( PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_CONTACTS_BY_ID);
              ResultSet resultSet = pStatement.executeQuery()) {
              while (resultSet.next()) {
                    Contact contact = parseResultSet(resultSet);
                    contacts.add(contact);
                }
        }
        return contacts;
    }

    public List<Contact> loadContactsDependingOnPage(Connection connection, int offset, int numOfRecords) throws SQLException {
        final List<Contact> contacts = new ArrayList<>();

        final String query = "SELECT SQL_CALC_FOUND_ROWS * FROM iTechArt.Contacts LIMIT "
                + offset + ", " + numOfRecords;

        try (
               PreparedStatement pStatement = connection.prepareStatement(query);
               ResultSet resultSet = pStatement.executeQuery()

            ) {
                 while (resultSet.next()){
                     Contact contact = parseResultSet(resultSet);
                     contacts.add(contact);
                 }
        }

        try (
                PreparedStatement pStatement = connection.prepareStatement("SELECT FOUND_ROWS()");
                ResultSet resultSet  = pStatement.executeQuery()
            ) {
                if (resultSet.next()){
                    this.numOfRecords = resultSet.getInt(1);
                }

        }
        return contacts;

    }

    public List<Contact> findContactsByName(String searchParam, Connection connection) throws SQLException {
        final List<Contact> contacts = new ArrayList<>();
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_SEARCH_CONTACTS_BY_NAME)) {
            final String queryParam = "%" + searchParam + "%";
            pStatement.setString(1, queryParam);
            pStatement.setString(2, queryParam);
            pStatement.setString(3, queryParam);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Contact contact = parseResultSet(resultSet);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    @Override
    public Contact load(int id, Connection connection) throws SQLException {
        Contact contact;
        ResultSet resultSet;
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_CONTACT_BY_ID)) {
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            resultSet.next();
            contact = parseResultSet(resultSet);
        }
        return contact;
    }

    @Override
    public Contact persist(Contact element, Connection connection, int contactId) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public Contact persist(Contact contact, Connection connection) throws SQLException {
        int contactId;
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement(pStatement, contact);
            pStatement.executeUpdate();
            ResultSet resultSet = pStatement.getGeneratedKeys();
            resultSet.next();
            contactId = resultSet.getInt(1);
            contact.setId(contactId);
        }
        return contact;
    }

    public void update(Contact contact, Connection connection) throws SQLException { //доделать
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_UPDATE_CONTACT)) {
            prepareStatement(pStatement, contact);
            pStatement.setInt(13, contact.getId());
            pStatement.executeUpdate();
        }
    }

    public void delete(Contact contact, Connection connection) throws SQLException { //доделать
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_DELETE_CONTACT)) {
            pStatement.setInt(1, contact.getId());
            pStatement.executeUpdate();
        }
    }

    private Contact parseResultSet(ResultSet resultSet) throws SQLException {
        final Contact contact = new Contact();
        contact.setId(resultSet.getInt("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setPatronymic(resultSet.getString("patronymic"));
        contact.setDateOfBirth(resultSet.getDate("date_of_birth"));
        contact.setGender(GenderType.valueOf(resultSet.getString("gender")));
        contact.setNationality(resultSet.getString("nationality"));
        contact.setMaritalStatus((MaritalStatus.valueOf(resultSet.getString("marital_status"))));
        contact.setWebSite(resultSet.getString("web_site"));
        contact.setEmail(resultSet.getString("email"));
        contact.setCurrentJob(resultSet.getString("current_job"));
        contact.setPhotoId(resultSet.getInt("photo_id"));
        contact.setAddressId(resultSet.getInt("address_id"));
        return contact;
    }

    private void prepareStatement(PreparedStatement pStatement, Contact contact) throws SQLException {
        pStatement.setString(1, contact.getFirstName());
        pStatement.setString(2, contact.getLastName());
        pStatement.setString(3, contact.getPatronymic());
        pStatement.setDate(4, (Date) contact.getDateOfBirth());
        pStatement.setString(5, valueOf(contact.getGender()));
        pStatement.setString(6, contact.getNationality());
        pStatement.setString(7, valueOf(contact.getMaritalStatus()));
        pStatement.setString(8, contact.getWebSite());
        pStatement.setString(9, contact.getEmail());
        pStatement.setString(10, contact.getCurrentJob());
        pStatement.setInt(11, contact.getPhotoId());
        pStatement.setInt(12, contact.getAddressId());
    }
}
