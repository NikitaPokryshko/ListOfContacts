package com.itechart.pkr.controller;

/**
 * Created by nipo on 9/12/16.
 */
public class Example {

    public static void main(String[] args) {
        String s = "string";
        String s1;
        String s2 = "";

        if(s.isEmpty()){
            System.out.println(s);
        }

        if (s2.isEmpty()){
            System.out.println(s2 + "EmptyString");
        }

        Example example = new Example();


        System.out.println(Math.ceil(5.5));
        System.out.println(Math.ceil(5.6));
        System.out.println(Math.ceil(5.2));
        System.out.println(Math.ceil(4.37));
    }
}
