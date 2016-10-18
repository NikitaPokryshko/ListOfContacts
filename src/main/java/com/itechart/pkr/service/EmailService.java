package com.itechart.pkr.service;

import com.itechart.pkr.dao.ConnectionPool;
import com.itechart.pkr.dao.impl.ContactDao;
import com.itechart.pkr.domain.Contact;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class EmailService {

    private final String username = "iTechArtLab@gmail.com";
    private final String password = "8094239196";

    public static ArrayList<Contact> getContactsWithBd(){
        ArrayList<Contact> todayBdContacts = null;
        Connection connection;
        ContactDao contactDao;
        try {
            connection = ConnectionPool.getConnection();
            contactDao = ContactDao.getDao();
            List<Contact> allContacts = contactDao.loadAllContacts(connection);
            todayBdContacts = new ArrayList<>();

            String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String todayMMdd = today.substring(5, 10);

            for(Contact con : allContacts){

                String contactMMdd = String.valueOf(con.getDateOfBirth()).substring(5,10);
                if(contactMMdd.equals(todayMMdd)){

                    todayBdContacts.add(con);
                }

            }

            ConnectionPool.returnConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todayBdContacts;
    }

    public Session createSession(){

        InputStream in = EmailService.class.getClassLoader().getResourceAsStream("mail.properties");
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

    }

    public void sendMails(Session session, String to, String theme, String text) throws MessagingException{

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject(theme);
        message.setText(text);

        Transport.send(message);


    }


}
