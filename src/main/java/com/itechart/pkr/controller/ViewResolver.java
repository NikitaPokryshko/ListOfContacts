package com.itechart.pkr.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nipo on 9/8/16.
 */
public class ViewResolver {

    public String resolveView(View view){

        if (view.isRedirect()){

            return "/web/" + view.getViewID();

        } else return "/WEB-INF/views/" + view.getViewID() + ".jsp";

    }
}
