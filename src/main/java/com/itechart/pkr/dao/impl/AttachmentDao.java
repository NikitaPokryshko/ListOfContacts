package com.itechart.pkr.dao.impl;

import com.itechart.pkr.dao.BaseDAO;
import com.itechart.pkr.domain.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by nipo on 11/26/15.
 */
public class AttachmentDao implements BaseDAO<Attachment> {

    private static final Logger log = Logger.getLogger(AttachmentDao.class);

    private static AttachmentDao thisDao = null;

    private AttachmentDao() throws SQLException{

    }

    public static synchronized AttachmentDao getDao()throws SQLException {

            if (thisDao == null) {
                thisDao = new AttachmentDao();
            }

        return thisDao;
    }

    public ArrayList<Attachment> loadAllAttachments(int contactId, Connection connection) throws SQLException, NullPointerException {
        String SQL_SELECT_ATTACHMENTS_BY_CONTACT_ID = "SELECT * FROM `iTechArt`.Attachments WHERE contact_id = ?";
        ArrayList<Attachment> attachments = new ArrayList<Attachment>();
        try (PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_ATTACHMENTS_BY_CONTACT_ID)) {
            pStatement.setInt(1, contactId);

            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Attachment attachment = new Attachment();
                attachment.setId(resultSet.getInt("id"));
                attachment.setAttachPath(resultSet.getString("attach_path"));
                attachment.setAttachmentFileName(resultSet.getString("attachment_file_name"));
                attachment.setDateOfDownload(resultSet.getDate("date_of_download"));
                attachment.setComment(resultSet.getString("comment"));
                attachments.add(attachment);
            }

            resultSet.close();

        }
        return attachments;
    }

    public Attachment load(int id, Connection connection) throws SQLException {
        String SQL_SELECT_ATTACHMENTS_BY_ID = "SELECT * FROM `iTechArt`.Attachments WHERE id = ?";
        Attachment attachment = new Attachment();

        try(PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_ATTACHMENTS_BY_ID)) {
            pStatement.setInt(1, id);

            ResultSet resultSet = pStatement.executeQuery();
            resultSet.next();
            attachment.setId(resultSet.getInt("id"));
            attachment.setAttachmentFileName(resultSet.getString("attachment_file_name"));
            attachment.setAttachPath("attach_path");
            attachment.setDateOfDownload(resultSet.getDate("date_of_download"));
            attachment.setComment(resultSet.getString("comment"));
            resultSet.close();

        }
        return attachment;
    }

    public Attachment persist(Attachment attachment, Connection connection, int contactId) throws SQLException {
        int attachmentId;
        String SQL_INSERT_ATTACHMENTS = "INSERT INTO `iTechArt`.Attachments (attachment_file_name, attach_path, date_of_download, comment, contact_id) values ( ?, ?, ?, ?, ?);";
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_ATTACHMENTS, Statement.RETURN_GENERATED_KEYS)) {

                pStatement.setString(1, attachment.getAttachmentFileName());
                pStatement.setString(2, attachment.getAttachPath());
                pStatement.setDate(3, (Date) attachment.getDateOfDownload());
                pStatement.setString(4, attachment.getComment());
                pStatement.setInt(5, contactId);
                pStatement.executeUpdate();

                ResultSet resultSet = pStatement.getGeneratedKeys();
                resultSet.next();
                attachmentId = resultSet.getInt(1);
                attachment.setId(attachmentId);
                resultSet.close();

            //возможно надо будет убрать генерацию

        }
        return attachment;
    }

    public void update(Attachment attachment, Connection connection) throws SQLException {
        String SQL_UPDATE_ATTACHMENTS = "UPDATE `iTechArt`.Attachments SET attachment_file_name = ?, attach_path = ?, date_of_download = ?, comment = ? WHERE id = ?;";
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_UPDATE_ATTACHMENTS)){

                pStatement.setString(1, attachment.getAttachmentFileName());
                pStatement.setString(2, attachment.getAttachPath());
                pStatement.setDate(3, (Date) attachment.getDateOfDownload());
                pStatement.setString(4, attachment.getComment());
                pStatement.setInt(5, attachment.getId());
                pStatement.executeUpdate();

        }
    }

    public void delete(Attachment attachment, Connection connection) throws SQLException {
        String SQL_DELETE_ATTACHMENTS = "DELETE FROM `iTechArt`.Attachments WHERE id = ?;";
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_DELETE_ATTACHMENTS)) {
                pStatement.setInt(1, attachment.getId());
                pStatement.executeUpdate();


        }
    }
}
