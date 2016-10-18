package com.itechart.pkr.service;

import com.itechart.pkr.dao.ConnectionPool;
import com.itechart.pkr.dao.impl.AttachmentDao;
import com.itechart.pkr.domain.Attachment;
import com.itechart.pkr.domain.Contact;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class AttachmentService {

        private AttachmentDao            attachmentDao;
        private static AttachmentService thisService = null;

        private AttachmentService() throws SQLException {
            this.attachmentDao = attachmentDao.getDao();
        }

        public static synchronized AttachmentService getService() throws SQLException{
            if (thisService == null) {
                thisService = new AttachmentService();
            }

            return thisService;
        }

        public void addAllAttachments(ArrayList<Attachment> attachments, Contact contact){
            Connection connection = null;
            try {

                connection = ConnectionPool.getConnection();

                if(!attachments.isEmpty()) {
                    for (Attachment att : attachments) {

                        this.attachmentDao.persist(att, connection, contact.getId());

                    }
                }
                ConnectionPool.returnConnection(connection);


            }catch (SQLException e){
                e.printStackTrace();
                //logging
            }

        }

        public ArrayList<Attachment> loadAllAttachments(Contact contact){
            Connection connection = null;
            ArrayList<Attachment> attachments = null;
            try {

                connection = ConnectionPool.getConnection();
                attachments = this.attachmentDao.loadAllAttachments(contact.getId(), connection);
                ConnectionPool.returnConnection(connection);

            }catch (SQLException e){
                e.printStackTrace();
                //logging
            }

            return attachments;

        }
        public void updateAllAttachments(ArrayList<Attachment> attachments){
            Connection connection = null;
            try {

                connection = ConnectionPool.getConnection();
                if(!attachments.isEmpty())
                    for(Attachment att : attachments){
                        this.attachmentDao.update(att, connection);
                    }

                ConnectionPool.returnConnection(connection);

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public void deleteAttachment(ArrayList<Attachment> attachments){
            Connection connection = null;
            try {

                connection = ConnectionPool.getConnection();

                if(!attachments.isEmpty())
                    for(Attachment att : attachments){

                        this.attachmentDao.delete(att, connection);
                    }

                ConnectionPool.returnConnection(connection);

            } catch (SQLException e){
                e.printStackTrace();
            }

        }
}
