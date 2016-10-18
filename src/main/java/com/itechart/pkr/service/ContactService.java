package com.itechart.pkr.service;

import com.itechart.pkr.dao.ConnectionPool;
import com.itechart.pkr.dao.impl.*;
import com.itechart.pkr.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ContactService {

    private ContactDao contactDao;
    private AddressDao addressDao;
    private PhoneDao phoneDao;
    private AttachmentDao attachmentDao;
    private PhotoDao photoDao;

    private static volatile ContactService thisService;

    private ContactService() throws SQLException {
        this.contactDao = ContactDao.getDao();
        this.addressDao = AddressDao.getDao();
        this.phoneDao = PhoneDao.getDao();
        this.attachmentDao = AttachmentDao.getDao();
        this.photoDao = PhotoDao.getDao();
    }

    public static ContactService getService() throws SQLException {
        if (thisService == null) {
            synchronized (ContactService.class) {
                if (thisService == null) {
                    thisService = new ContactService();
                }
            }
        }
        return thisService;
    }

    public Contact contactLoad(int id) {
        Contact contact = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            contact = contactDao.load(id, connection);
            initContactDependencies(contact, connection);
            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {

            try {
                //  if (connection!=null) ecли не проверять - возможна NullPointerException
                //Log exception
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                //Log exception
            }
        }
        return contact;
    }

    private void initContactDependencies(Contact contact, Connection connection) throws SQLException {

        final Address address = addressDao.load(contact.getAddressId(), connection);
        contact.setAddress(address);
        final Photo photo = photoDao.load(contact.getPhotoId(), connection);
        contact.setPhoto(photo);
        final List<Phone> phones = this.phoneDao.loadAllPhones(contact.getId(), connection);
        contact.setPhones(phones);
        final List<Attachment> attachments = this.attachmentDao.loadAllAttachments(contact.getId(), connection);
        contact.setAttachments(attachments);
    }

    public void loadContactsDependingOnPage(int page, int recordsPerPage, HttpServletRequest request){
        List<Contact> contacts;
        Connection connection = null;

        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            contacts = this.contactDao.loadContactsDependingOnPage(connection, (page-1)*recordsPerPage, recordsPerPage);
            for (Contact contact : contacts){
                initContactDependencies(contact, connection);
            }
            int numOfRecords = this.contactDao.getNumOfRecords();
            int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("contacts", contacts);
            request.setAttribute("numOfPages", numOfPages);
            request.setAttribute("currentPage", page);
            connection.commit();
            ConnectionPool.returnConnection(connection);

        } catch (SQLException e){
            try {
                if(connection != null){
                    connection.rollback();
                }
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    public List<Contact> loadAllContacts() {
        List<Contact> contacts = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            contacts = this.contactDao.loadAllContacts(connection);
            for (Contact contact : contacts) {
                initContactDependencies(contact, connection);
            }
            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return contacts;
    }

    public Contact contactAdd(Contact contact) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            final Address address = addressDao.persist(contact.getAddress(), connection);
            final Photo photo = photoDao.persist(contact.getPhoto(), connection);
            contact.setAddressId(address.getId());
            contact.setPhotoId(photo.getId());
            contact.setAddress(address);
            contact.setPhoto(photo);

            int contactId = contactDao.persist(contact, connection).getId();
            contact.setId(contactId);

            for (Phone ph : contact.getPhones()) {
                int phoneId = phoneDao.persist(ph, connection, contactId).getId();
                ph.setId(phoneId);
            }

            for (Attachment att : contact.getAttachments()) {
                int attachId = attachmentDao.persist(att, connection, contactId).getId();
                att.setId(attachId);
            }
            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return contact;
    }

    public void contactDelete(Contact contact) {
        // added if operators to attachs and phones( mb delete them after testing)

        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            if(contact.getPhones() != null && contact.getPhones().size() != 0){
                for (Phone ph : contact.getPhones()) {
                    phoneDao.delete(ph, connection);
                }
            }

            if(contact.getAttachments() != null && contact.getAttachments().size() != 0){
                for (Attachment att : contact.getAttachments()) {
                    attachmentDao.delete(att, connection);
                }
            }

            contactDao.delete(contact, connection);
            addressDao.delete(contact.getAddress(), connection);
            photoDao.delete(contact.getPhoto(), connection);

            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {

            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }

    public Contact contactUpdate(Contact contact) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            contactDao.update(contact, connection);
            addressDao.update(contact.getAddress(), connection);
            photoDao.update(contact.getPhoto(), connection);

            for (Phone ph : contact.getPhones()) {
                phoneDao.update(ph, connection);
            }
            for (Attachment att : contact.getAttachments()) {
                attachmentDao.update(att, connection);
            }
            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return contact;
    }

    public List<Contact> findContactsByName(String searchParam) {
        List<Contact> contacts = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            contacts = contactDao.findContactsByName(searchParam, connection);
            for (Contact contact : contacts) {
                initContactDependencies(contact, connection);
            }
            connection.commit();
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return contacts;
    }


}
