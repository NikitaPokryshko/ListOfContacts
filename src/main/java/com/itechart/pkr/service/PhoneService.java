package com.itechart.pkr.service;


import com.itechart.pkr.dao.ConnectionPool;
import com.itechart.pkr.dao.impl.*;
import com.itechart.pkr.domain.Contact;
import com.itechart.pkr.domain.Phone;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneService {

    private PhoneDao phoneDao;
    private static PhoneService thisService = null;

    private PhoneService() throws SQLException {

        this.phoneDao = PhoneDao.getDao();

    }

    public static synchronized PhoneService getService() throws SQLException{

        if (thisService == null) {
            thisService = new PhoneService();
        }

        return thisService;
    }

    public void addAllPhones(ArrayList<Phone> phones, Contact contact){
        Connection connection = null;
        try {

            connection = ConnectionPool.getConnection();

            if(!phones.isEmpty()) {
                for (Phone ph : phones) {

                    this.phoneDao.persist(ph, connection, contact.getId());

                }
            }
            ConnectionPool.returnConnection(connection);


        }catch (SQLException e){
            e.printStackTrace();
            //logging
        }

    }

    public ArrayList<Phone> loadAllPhones(Contact contact){
        Connection connection = null;
        ArrayList<Phone> phones = null;
        try {

            connection = ConnectionPool.getConnection();
            phones = this.phoneDao.loadAllPhones(contact.getId(), connection);
            ConnectionPool.returnConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
            //logging
        }

        return phones;

    }
    public void updateAllPhones(ArrayList<Phone> phones){
        Connection connection = null;
        try {

            connection = ConnectionPool.getConnection();
            if(!phones.isEmpty())
            for(Phone ph : phones){

                this.phoneDao.update(ph, connection);

            }

            ConnectionPool.returnConnection(connection);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePhone(ArrayList<Phone> phones){
        Connection connection = null;
        try {

            connection = ConnectionPool.getConnection();

            if(!phones.isEmpty())
            for(Phone ph : phones){

                this.phoneDao.delete(ph, connection);
            }

            ConnectionPool.returnConnection(connection);

        } catch (SQLException e){
            e.printStackTrace();
        }

    }


}
