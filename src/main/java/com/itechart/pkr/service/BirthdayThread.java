package com.itechart.pkr.service;

import com.itechart.pkr.dao.impl.ContactDao;
import com.itechart.pkr.domain.Contact;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.sql.Connection;
import java.util.ArrayList;


public class BirthdayThread implements Runnable {

    private final String email = "nikitay3@yandex.ru";
    private ContactDao              contactDao;
    private Connection              connection;
    private EmailService            emailService;


    @Override
    public void run() {
          //while ругается
        while(true){
                ArrayList<Contact> todayBdContacts = EmailService.getContactsWithBd();
                emailService = new EmailService();
                Session session = emailService.createSession();

                if (todayBdContacts.size() > 0) {

                    for (Contact contact : todayBdContacts) {

                        try {//TODO отправлять на почту администратору спиоск всех контактов, у которых день рождния

                            emailService.sendMails(session, contact.getEmail(), "Happy Birthday!", "Happy birthday, dear " + contact.getFullName());
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }

            try {
                Thread.sleep(86400000);
            } catch (Throwable th) {
                th.printStackTrace();
                //todo log
            }

        }

    }
}
