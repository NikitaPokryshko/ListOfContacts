package com.itechart.pkr.domain;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by nipo on 11/16/15.
 */
public class DomainObject {
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //писал Жека
    public String getJSONDescribe () throws IllegalAccessException {

        final Class clazz = this.getClass();

        final StringBuilder builder = new StringBuilder( "{" );

        Class tempClazz = clazz;
        if ( clazz.getSuperclass() != null ) {

            tempClazz = tempClazz.getSuperclass();

            this.populateJSON(builder, tempClazz);

        }

        this.populateJSON( builder, clazz );

        builder.deleteCharAt( builder.length() - 1 );
        builder.append( "}" );

        return builder.toString();

    }

    //писал Жека
    public void populateJSON ( StringBuilder builder, Class clazz ) throws IllegalAccessException {

        for ( Field field : clazz.getDeclaredFields() ) {

            field.setAccessible(true);

            String type = field.getType().getTypeName();

            String value = "";
            if ( "java.util.Date".equals( type ) ) {

                DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                Date date = (Date) field.get(this);
                value = format.format(date);

            } else if ( "com.itechart.pkr.domain.PhoneType".equals( type ) ) {

                PhoneType phoneType = (PhoneType) field.get(this);
                value = String.valueOf(phoneType);

            } else if ( "java.lang.String".equals( type ) ) {

                value = (String) field.get(this);

            } else if ( "java.lang.Integer".equals( type ) ) {

                value = String.valueOf( (Integer) field.get(this) );

            }

            builder.append("\"" + field.getName() + "\":\"" + value + "\",");

        }

    }

}
