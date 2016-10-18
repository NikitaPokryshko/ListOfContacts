package com.itechart.pkr.controller;

/**
 * Created by nipo on 9/7/16.
 */
public class View {


    private String viewID;
    private boolean isRedirect;

    public View(String viewID) {
        this.viewID = viewID;
    }

    public String getViewID() {
        return viewID;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }



}
