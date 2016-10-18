package com.itechart.pkr.dao.impl;

import com.itechart.pkr.dao.BaseDAO;
import com.itechart.pkr.domain.Photo;

import java.sql.*;

/**
 * ПЕРЕДЕЛАТЬ, ЕСЛИ ФОТО ХРАНИТЬ БУДУ ИНАЧЕ В БД
 */
public class PhotoDao implements BaseDAO<Photo> {

    //private static final Logger log = Logger.getLogger(PhotoDao.class);

    private static PhotoDao thisDao = null;

    private PhotoDao() throws SQLException{

    }

    public static synchronized PhotoDao getDao()throws SQLException {

            if (thisDao == null) {
                thisDao = new PhotoDao();
            }
        return thisDao;
    }

    public Photo load(int id, Connection connection) throws SQLException {

        String SQL_SELECT_PHOTO_BY_ID = "SELECT * FROM `iTechArt`.Photo WHERE id = ?;";
        Photo photo = new Photo();
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_SELECT_PHOTO_BY_ID)) {
                pStatement.setInt(1, id);

                ResultSet resultSet = pStatement.executeQuery();
                resultSet.next();
                photo.setId(resultSet.getInt("id"));
                photo.setPhotoReference(resultSet.getString("photo_reference"));
        }

        return photo;

    }

    @Override
    public Photo persist(Photo photo, Connection connection, int contactId) throws SQLException {
        return photo; //пустой метод для соблюдения правил имплементирования
    }

    public Photo persist(Photo photo, Connection connection) throws SQLException {
        int photoId;
        String SQL_INSERT_PHOTO = "INSERT INTO `iTechArt`.Photo (photo_reference) VALUES (?);";

        try (PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_PHOTO, Statement.RETURN_GENERATED_KEYS)) {

            pStatement.setString(1, photo.getPhotoReference());
            pStatement.executeUpdate();

            ResultSet resultSet = pStatement.getGeneratedKeys();
            resultSet.next();
            photoId = resultSet.getInt(1);
            photo.setId(photoId);
            //генерацию возможно надо убрать
        }
        return photo;
    }


    public void update(Photo photo, Connection connection) throws SQLException {
        String SQL_UPDATE_PHOTO = "INSERT INTO `iTechArt`.Photo (photo_reference) VALUES (?);";

        try(PreparedStatement pStatement = connection.prepareStatement(SQL_UPDATE_PHOTO)) {

                pStatement.setString(1, photo.getPhotoReference());
                pStatement.executeUpdate();
        }
    }

    public void delete(Photo photo, Connection connection) throws SQLException {
        String SQL_DELETE_PHOTO = "DELETE FROM `iTechArt`.Photo WHERE id=?;";
        try(PreparedStatement pStatement = connection.prepareStatement(SQL_DELETE_PHOTO)) {
                pStatement.setInt(1, photo.getId());
                pStatement.executeUpdate();

        }
    }
}
