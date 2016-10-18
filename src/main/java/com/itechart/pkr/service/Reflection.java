package com.itechart.pkr.service;

import com.itechart.pkr.domain.PhoneType;
import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Reflection {

    private Reflection () {
    }

    public static String getObjectDescribeAsJSON ( final Class clazz ) {

        final StringBuilder builder = new StringBuilder( "{" );

        builder.append( "\"type\":\"" + clazz.getSimpleName() + "\",\"fields\":[" );

        Class tempClazz = clazz;
        if ( clazz.getSuperclass() != null ) {

            tempClazz = tempClazz.getSuperclass();

            Reflection.populateJSON( builder, tempClazz );
            System.out.println();

        }

        Reflection.populateJSON( builder, clazz );

        builder.deleteCharAt( builder.length() - 1 );
        builder.append( "]}" );

        return builder.toString();

    }

    /*public static void setFieldValue ( final Field field, final String value, final Object obj ) throws java.text.ParseException, IllegalAccessException {
        //TODO убрать комментарий ПОТОМ! СДЕЛАНО, Т.К ИСОПЛЬЗУЮТСЯ ФИЧИ ИЗ JAVA 8, А В ТРЕБОВАНИЯХ БЫЛА 7
        //final String type; field.getType().getTypeName();

        field.setAccessible( true );

        if ( "java.util.Date".equals( type ) ) {

            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
            Date parsedDate = formatter.parse( value );
            field.set( obj, parsedDate );

        } else if ( "com.itechart.pkr.domain.PhoneType".equals( type ) ) {

            PhoneType phoneType = PhoneType.valueOf( value );
            field.set( obj, phoneType );

        } else if ( "java.lang.String".equals( type ) ) {

            field.set( obj, value );

        } else if ( "java.lang.Integer".equals( type ) ) {

            field.set( obj, Integer.valueOf( value ) );

        }

    }*/

    public static void populateJSON ( StringBuilder builder, Class clazz ) {

        for ( Field field : clazz.getDeclaredFields() ) {

            builder.append( "\"" + field.getName() + "\"," );
            

        }

    }

}
