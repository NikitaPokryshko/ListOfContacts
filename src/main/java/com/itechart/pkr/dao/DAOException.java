package com.itechart.pkr.dao;

/**
 * Created by nipo on 11/25/15.
 */
public class DAOException extends Exception {

    public DAOException(){
        super();
    }

    public DAOException(String message, Throwable cause){
        super(message, cause);
    }

    public DAOException(String message){
        super(message);
    }
}
