package com.itechart.pkr.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by nipo on 12/9/15.
 */
public class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc/iTechArt";
    private static DataSource dataSource;


    private ConnectionPool(){

    }

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);


        } catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void returnConnection(Connection connection){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }



}
